/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ContatoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Contato;

/**
 *
 * @author danieljunior
 */
public class AdicionaContatoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
                out.println("Erro na conversão da data");
            }
            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setEndereco(endereco);
            contato.setDataNascimento(dataNascimento);

            ContatoDao db = new ContatoDao();
            db.adiciona(contato);

            RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
}
