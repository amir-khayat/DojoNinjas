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
<title>Add Ninja</title>
</head>
<body>

	<div class="container">

		<h1>Add Ninja</h1>
		<form:form method="post" action="/createNinja" modelAttribute="ninja">
			<div class="form-group mb-3">
				<c:if test="${BindingResult.hasErrors()}">
					<div class="alert alert-danger mt-3 d-block ">
						<h5>
							<strong>Validation Error:</strong>
						</h5>
						<div class="mb-3">
							<form:errors path="firstName" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:errors path="lastName" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:errors path="age" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:errors path="dojo" class="text-danger" />
						</div>
					</div>
				</c:if>
				<form:label class="col-sm-3 control-label" path="firstName">First Name:</form:label>
				<div class="col-sm-9">
					<form:input path="firstName" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group mb-3">
				<form:label class="col-sm-3 control-label" path="lastName">Last Name:</form:label>
				<div class="col-sm-9">
					<form:input path="lastName" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group mb-3">
				<form:label class="col-sm-3 control-label" path="age">Age:</form:label>
				<div class="col-sm-9">
					<form:input path="age" type="number" class="form-control" />
				</div>
			</div>
			<div class="form-group mb-3">
				<form:label class="col-sm-3 control-label" path="dojo">Dojo:</form:label>
				<div class="col-sm-9">
					<div class="dropdown">
						<form:select path="dojo" class="form-control">
							<<option value="" disabled selected>--Select Dojo--</option>
							<c:forEach items="${dojos}" var="dojo">
								<option value="${dojo.id}">${dojo.name}</option>
							</c:forEach>
						</form:select>
					</div>
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