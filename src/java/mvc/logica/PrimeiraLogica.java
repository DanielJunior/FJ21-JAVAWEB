/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danieljunior
 */
public class PrimeiraLogica implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica...");
        System.out.println("Redirecionando pro JSP...");
        RequestDispatcher rd = req.getRequestDispatcher("/primeira-logica.jsp");
        rd.forward(req, res);
    }

}
