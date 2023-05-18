<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Add Dojo</title>
</head>
<body>

	<div class="container">

		<h1>Add Dojo</h1>
		<form:form method="post" action="/createDojo" modelAttribute="dojo">
			<c:if test="${BindingResult.hasErrors()}">
				<div class="alert alert-danger mt-3 d-block ">
					<h5>
						<strong>Validation Error:</strong>
					</h5>
					<div class="mb-3">
						<form:errors path="name" class="text-danger" />
					</div>
				</div>
			</c:if>
			<div class="form-group mb-3">
				<form:label class="col-sm-3 control-label" path="name">Dojo Name:</form:label>
				<div class="col-sm-9">
					<form:input path="name" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<input type="submit" class="btn btn-primary" value="Submit" /> <a
						href="/" class="btn btn-secondary">Dojos</a>
				</div>
			</div>
		</form:form>

	</div>

</body>
</html>