package estagio


import grails.rest.*
import grails.converters.*

class CalculadoraController {
	static responseFormats = ['xml', 'json']
	
    def index() {
        render status: 200
     }


    // def soma() {
    //     BigDecimal termo1 = params.float("termo1")
    //     BigDecimal termo2 = params.float("termo2")

    //     render (termo1+termo2)
    // }

    def divisao() {
        BigDecimal result = 1
        BigDecimal index = 0

        try {
            request.JSON.termo.each {

            try {

               if (index == 0) {
                    result *= new BigDecimal(it)
                    index++
                } else {
                    result *= (1/new BigDecimal(it))
                }

            } catch (ArithmeticException) {
                render status: 422, message: "Divisao por 0"
            }
            catch( NumberFormatException ex) {
                render status: 422, message: "Erro ao formatar: ${it}"
            }
        }
  
    } catch (Exception ex) {
        render status: 422, ex.message
        return
    }
    
    render result
}

    def multiplicacao() {
        BigDecimal mult = 1
        request.JSON.termo.each {
            try {
                mult *= new BigDecimal(it)
            } catch( NumberFormatException ex) {
                render status: 422, message: "Erro ao converter o termo '${it}'" 
                return
            } 
            
        } 
        render mult
         
    } 

    def soma2() {
        BigDecimal soma = 0


        
         request.JSON.termo.each { 
            try { 
                soma += new BigDecimal(it)
            
            } catch(NumberFormatException ex) {
                render status: 422, message: "Erro ao converter o termo '${it}'" 
                return 
            } 
         }

         render soma
    }


    def potencia() {
        BigDecimal result = 1


        try {
            if(request.JSON.termo.length() > 2) {
                throw new Exception("Mais de 2 termos")
            } 

            try {
            for(int i = 0; i < request.JSON.termo[1]; i++) {
                result *= (request.JSON.termo[0])
            }

            } catch (Exception ex) {
                render status: 422, message: "Termo invalido ao converter"
            }

            
        } catch (Exception ex ) {
            render status: 422 , ex.message
            return
        }

        render result
    }


    def subtracao() {
        // BigDecimal result = -1 * (request.JSON.termo[0])
        BigDecimal result = 0
        BigDecimal index = 0

        try {
            if(request.JSON.termo.length() > 2) {
                throw new Exception("Mais de 2 termos")
                
            } 
            request.JSON.termo.each {
                try {
                    if (index == 0) {
                        result -= -1 * new BigDecimal(it)
                        index++
                    } else {
                        result += -1 * new BigDecimal(it)
                    }
                } catch (NumberFormatException ex) {
                    render status: 422, message: "Erro ao converter termo '${it}"
                    return
                }
         }
        }
          catch (Exception ex) {
            render status: 422, ex.message
            return
            }

        render result
    }


    // def subtracao2() {
    //     BigDecimal result = 0

    //     try {
    //     result = request.JSON.termo1 - request.JSON.termo2
    //     } catch(NumberFormatException ex) {
    //         render status: 422, message: "Erro ao converter"
    //     }
        
    // }

    // def soma3() {
    //     println request.JSON
    //     // render request.JSON
    //     try {
    //     render request.JSON.termo.sum()
    //     }  catch( Exception ex) {
    //         render status: 422, message: "Erro ss"
    //     }
    // }
}


