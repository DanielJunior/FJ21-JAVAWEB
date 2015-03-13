/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import dao.ContatoDao;
import java.sql.Connection;
import java.text.ParseException;
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
public class AdicionaContatoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse res) throws Exception {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;
        try {
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            return "erro.html";
        }
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        contato.setDataNascimento(dataNascimento);

        ContatoDao db = new ContatoDao((Connection) request.getAttribute("conexao"));
        db.adiciona(contato);
        return new ListaContatosLogic().executa(request, res);

    }

}
