package estagio


import grails.rest.*
import grails.converters.*

class CidadeController {
	static responseFormats = ['json', 'xml']
	
    def index() { 
        respond Cidade.list()
    }


    def save(Cidade cidade) {
        cidade.save()
        respond cidade
    }
}
