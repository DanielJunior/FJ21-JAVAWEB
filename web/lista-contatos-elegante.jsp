<%-- 
    Document   : lista-contatos-elegante
    Created on : 06/03/2015, 17:24:41
    Author     : danieljunior
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>

        <table>

            <c:forEach var="contato" items="${contatos}">
                <tr>
                    <td>${contato.nome}</td>
                    <td>
                        <c:if test="${not empty contato.email}">
                            <a href="mailto:${contato.email}">${contato.email}</a>
                        </c:if>
                        <c:if test="${empty contato.email}">
                            E-mail não informado
                        </c:if>
                    </td>
                    <td>${contato.endereco}</td>
                    <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
                    <td>
                        <a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
                    </td>
                    <td>
                        <a href="mvc?logica=AlteraContato&id=${contato.id}">Alterar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <button><a href="mvc?logica=AdicionaContato">Novo Contato</a></button>
        <c:import url="rodape.jsp"/>

    </body>
</html>
