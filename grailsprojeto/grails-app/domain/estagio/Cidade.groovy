package estagio

class Cidade {

    String nome
    String uf


    static hasMany = [pessoas: Pessoa]

    static constraints = {
    }
}
