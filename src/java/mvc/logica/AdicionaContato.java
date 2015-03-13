/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danieljr
 */
public class AdicionaContato implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        return "adiciona-contato.jsp";
    }

}
