<%-- 
    Document   : user
    Created on : 13 févr. 2016, 19:43:05
    Author     : Youssef
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>x</title>
        <link rel="stylesheet" type="text/css" href="layout.css"/>
    </head>
    <body>
        
        <table border="1">
            <tr>
                
                
                <th>nom</th>
                <th>prenom</th>
                <th>ville</th>
                <th>numéro</th>
                <th>adresse</th>
                 <th>code postal</th>
                <th>offres</th>
                <th>image</th>
                
                
            </tr>
            <c:forEach items="${results}" var="agents">
                <tr></tr>
                <tr>
                    <td><c:out value="${agents.nomagent}"/> </td>
                    <td><c:out value="${agents.prenomagent}}"/> </td>
                    <td><c:out value="${agents.nomvilleagent}"/></td>
                    <td><c:out value="${agents.telagent}"/> </td>
                    <td><c:out value="${agents.nompadresseagent}"/> </td>

                    <td><c:out value="${agents.codepostalagent}"/> </td>
                    <td><c:out value="${agents.offreAgent}"/> </td>

                    <td><img src="${agents.photochemin}" width="450" height="450"/> </td>
               </tr>
                    
            </c:forEach>   
        </table>
        
    </body>
</html>
