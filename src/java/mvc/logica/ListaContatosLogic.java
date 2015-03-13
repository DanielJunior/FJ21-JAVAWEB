/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import dao.ContatoDao;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Contato;

/**
 *
 * @author danieljr
 */
public class ListaContatosLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        List<Contato> contatos = new ContatoDao((Connection) req.getAttribute("conexao")).getLista();
        req.setAttribute("contatos", contatos);
        return "lista-contatos-elegante.jsp";
    }

}
