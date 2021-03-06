/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import dao.ContatoDao;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Contato;

/**
 *
 * @author danieljr
 */
public class AlteraContatoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse res) throws Exception {
        Contato contato = new Contato();
        String id = request.getParameter("id");
        contato.setId(Long.parseLong(id));
        contato.setNome(request.getParameter("nome"));
        contato.setEndereco(request
                .getParameter("endereco"));
        contato.setEmail(request.getParameter("email"));
        //Converte a data de String para Calendar
        String dataEmTexto = request
                .getParameter("dataNascimento");
        Date date = new SimpleDateFormat("dd/MM/yyyy")
                .parse(dataEmTexto);
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(date);
        contato.setDataNascimento(dataNascimento);
        ContatoDao db = new ContatoDao((Connection) request.getAttribute("conexao"));
        db.alterar(contato);
        return new ListaContatosLogic().executa(request, res);

    }

}
