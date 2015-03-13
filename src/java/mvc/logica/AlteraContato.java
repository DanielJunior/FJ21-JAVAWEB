/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import dao.ContatoDao;
import factories.ConnectionFactory;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Contato;

/**
 *
 * @author danieljunior
 */
public class AlteraContato implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse res) throws Exception {

        ContatoDao db = new ContatoDao((Connection) request.getAttribute("conexao"));
        long id = Long.parseLong(request.getParameter("id"));
        Contato contato = db.pesquisar(id);
        request.setAttribute("contato", contato);
        return "altera-contato.jsp";
    }

}
