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

        <jsp:useBean id="dao" class="dao.ContatoDao" />
        <table>

            <c:forEach var="contato" items="${dao.lista}">
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
                </tr>
            </c:forEach>
        </table>
        <c:import url="rodape.jsp"/>

    </body>
</html>
