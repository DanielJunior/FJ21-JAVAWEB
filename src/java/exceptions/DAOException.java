/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author danieljunior
 */
public class DAOException extends RuntimeException{

    public DAOException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "Erro na operação SQL \n"+super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
