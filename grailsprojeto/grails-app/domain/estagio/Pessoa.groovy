package estagio

class Pessoa {

    String nome
    String cpf

    static belongsTo = [ cidade: Cidade]

    static constraints = {
        cpf unique: true

    }
}
