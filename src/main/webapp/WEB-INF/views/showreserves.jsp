<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"  %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>


<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>





</head>
<body>
<div class="container">

<table class="table table-hover">
<thead> <tr><td>Nr</td><td>Imie</td><td>Nazwisko</td><td>Film</td><td>Godzina</td><td></td> </tr> </thead>
<c:forEach var="reserve" items="${reserves}">
<tr>
	<td>${reserve.id}</td>
	<td>${reserve.name}</td>
	<td>${reserve.surname}</td>
	<td>${reserve.movietype}</td>
	<td>${reserve.hour}</td>
	<td><a class="btn" href="<spring:url value="/deletereserve/${reserve.id}" />" >Delete</a></td>
</tr>
</c:forEach>

</table>
<a href="<spring:url value="/" />" >Home</a>

</div>
</body>
</html>