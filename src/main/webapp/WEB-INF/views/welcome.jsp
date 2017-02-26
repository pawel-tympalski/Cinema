<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<%@ page import="java.util.regex.Pattern , java.util.regex.Matcher, com.cinema.comet.domain.Movie" %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>


<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>




<title>Insert title here</title>
<link rel="stylesheet" href='<spring:url value="/resources/css/welcome.css"></spring:url>' type="text/css">
</head>
<body>
<div class="container">
<h1>${przywitanie}</h1>

<h3>Repertuar</h3>
<c:forEach var="film" items="${listafilmow}">
<div class="well">
	<h4>${film.name}</h4>
	${film.type}
	${film.lenght} min
	| ${film.description}
	Godzina seansu
	<c:forEach var="hour" items="${film.hours}">
	    ${hour} 
	</c:forEach>
	
		<c:forEach var="part" items="${paths}">
	
		<%
		String ss = (String) pageContext.getAttribute("part");
		System.out.println(ss);
		
		Movie film = (Movie) pageContext.getAttribute("film");
		String filmName = film.getName();
		System.out.println(filmName);
		
		Pattern pattern = Pattern.compile(".*"+ filmName +".*");
		Matcher matcher = pattern.matcher(ss);
		Boolean bool = matcher.matches(); //zwraca true lub false
		pageContext.setAttribute("check", bool); 
		System.out.println(bool);
		
		
		%>
	
	
		<c:if test="${check eq true}"> 
		<img class="box" src="<c:url value='${part}'  />" width='50' height='50'/>
		</c:if>
		</c:forEach>
	
	
	
	
</div>
<br>
<br>
</c:forEach>

<h3>Rezerwacja biletów</h3>

<div class="row">
	<spring:url value="/reserve" var="formURL"></spring:url>
	<form:form  action="${formURL}" method="POST" modelAttribute="reserve">

		<div class="form-group">	
			<label for="project-name">Name</label>
			<form:input id="project-name" cssClass="form-control" path="name" />
		</div>
		
		<div class="form-group">
			<label for="project-surname" >Surname</label>
			<form:input id="project-surname" cssClass="form-control" path="surname"/>
			
		</div>
		
		<div class="form-group">
			<label for="project-movietype">MovieType</label> 
			<form:select id="project-movie" cssClass="selectpicker" path="movietype" items="${typeOptions}" />
		</div>

		<div class="form-group">
			<label for="project-hour" >Hour</label>
			<form:input  id="project-hour" cssClass="datapicker" path="hour"/>
			
		</div>
		
		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
</div>
</div>
</body>
</html>