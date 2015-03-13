<%-- 
    Document   : lista-contatos
    Created on : 01/03/2015, 11:28:33
    Author     : danieljunior
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, dao.*, modelos.*, factories.*, exceptions.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contatos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Endereço</th>
                    <th>Data de Nascimento</th>
                </tr>
            </thead>
            <tbody>
                <% ContatoDao db = new ContatoDao();
                    List<Contato> contatos = db.getLista();
                    for (Contato contato : contatos) {
                %>
                <tr>
                    <td><%=contato.getNome()%></td>
                    <td><%=contato.getEmail()%></td>
                    <td><%=contato.getEndereco()%></td>
                    <td><%= new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime())%></td>

                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
