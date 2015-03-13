<%-- 
    Document   : altera-contato
    Created on : 07/03/2015, 15:29:51
    Author     : danieljunior
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/jquery-ui.css">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        Formulário para alteração de contatos:<br/>
        <form action="mvc">
            Nome: <input name="nome" value="${contato.getNome()}"><br/>
            E-mail: <input name="email" value="${contato.getEmail()}"><br/>
            Endereço: <input type="text" name="endereco" value="${contato.getEndereco()}"><br/>
            Data de Nascimento: <caelum:campoData id="dataNascimento"/>
            <input type="hidden" name="logica" value="AlteraContatoLogic"/><br/>
            <input type="hidden" name="id" value="${contato.getId()}"/><br/>
            <input type="submit" value="Alterar"/>
        </form>
        <c:import url="rodape.jsp"/>
    </body>
</html>
