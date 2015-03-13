/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import dao.ContatoDao;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Contato;

/**
 *
 * @author danieljr
 */
public class RemoveContatoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        long id = Long.parseLong(req.getParameter("id"));

        Contato contato = new Contato();
        contato.setId(id);

        ContatoDao dao = new ContatoDao((Connection) req.getAttribute("conexao"));
        dao.remove(contato);

        System.out.println("Excluindo contato... ");

        return new ListaContatosLogic().executa(req, res);
    }

}
