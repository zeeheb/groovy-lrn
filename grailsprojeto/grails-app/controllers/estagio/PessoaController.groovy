package estagio


import grails.rest.*
import grails.converters.*

class PessoaController {
	static responseFormats = ['json', 'xml']
	



    def index() {
        respond Pessoa.list()

     }

    def save() {
        
        def pessoa = new Pessoa()

        pessoa.nome = request.JSON.nome
        pessoa.cpf = request.JSON.cpf

        pessoa.save()

        respond pessoa
    }

    def save2(){
        def pessoa = Pessoa.get(params.id)
        bindData(pessoa, request.JSON)
        pessoa.save()
        respond pessoa
    }

    def show(Pessoa pessoa) {
        respond pessoa
    }

    def show2() {
        def pessoa = Pessoa.get(params.id)
        respond pessoa
    }

    def search() {
       respond Pessoa.findAllByNomeOrCpf(params.nome, params.cpf)
    }
 

}
