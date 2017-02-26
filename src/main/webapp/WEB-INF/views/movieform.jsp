<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
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
<spring:url value="form123/save" var="formURL"></spring:url>
<form:form  action="${formURL}" method="POST" modelAttribute="movie">
<h4>Dodaj Film do bazy danych</h4>
	<div class="form-group">
		<label for="project-name" >Name</label>
		<form:input id="project-name" cssClass="form-control" path="name"/>
	</div>

	<div class="form-group">		
		<label for="project-type">Type</label>
		<form:input id="project-type" cssClass="form-control" path="type"/>
	</div>

	<div class="form-group">
		<label for="project-lenght" >Lenght</label>
		<form:input id="project-lenght" cssClass="form-control" path="lenght"/>
	</div>

	<div class="form-group">
		<label for="project-description">Description</label>
		<form:textarea id="for-project" cssClass="form-control" path="description"/>
	</div>

<form:select multiple="true" path="hours" items="${MOVIEHOURS}"  cssClass="pointpiceker">
	

</form:select>
<button type="submit"  class="btn btn-default">Submit</button>

</form:form>




<spring:url value="/addimage" var="formURL"></spring:url>
	<form:form  action="${formURL}" method="POST" enctype="multipart/form-data">

		
		
		<div class="form-group">
			<input type="file" name="file">
		
		</div>
		
		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
	


</div>
</body>
</html>