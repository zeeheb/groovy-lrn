package estagio

import grails.transaction.Transactional

@Transactional
class CalculadoraService {

    def soma(termo) {
        
    BigDecimal soma = 0


        
    termo.each { 
        soma += new BigDecimal(it)
    }

    return soma
        
    }
}
