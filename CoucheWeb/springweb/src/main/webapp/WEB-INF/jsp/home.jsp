<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Equipe société Objis</title>
</head>
<body>
<h2>Ils vont vous faire aimer java</h2>
<ul>
<c:forEach items="${employes}" var="employe">
<li>
<c:out value="${employe.nom}"/>
<c:out value="${employe.prenom}"/>
<c:out value="${employe.email}"/>
</li>
</c:forEach></ul>



</body>
</html>