<%-- 
    Document   : bemvindo
    Created on : 01/03/2015, 11:20:26
    Author     : danieljunior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem-vindo!</title>
    </head>
    <body>
        <%-- minha primeira JSP --%>
        <%
            String mensagem = "Bem vindo ao sistema de agenda do FJ-21!!!";
        %>
        <%
            out.println(mensagem);
        %></br>
        <%
            String desenvolvido = "Desenvolvido por Daniel Junior";
        %>
        <%= desenvolvido%></br>
        <% System.out.println("Tudo foi executado!");%>
    </body>
</html>
