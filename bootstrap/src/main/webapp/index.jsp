<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to My Film Database</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Custom style sheet -->
<link rel="stylesheet" href="css/stylesheet.css">
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet"/>
<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<!-- Bootstrap Icon CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

</head>

<body id = "body">
	<div class="container mt-5">
		<div class="text-center">
			<h1 class="display-5 mb-5">
				<strong>Film Database</strong>
			</h1>
		</div>
	</div>


	<nav>
		<ul>
			<li><a href="./getAllFilms">Home</a></li>
			<li><a href="./getAllFilms">Films</a></li>
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">About Us</a></li>
		</ul>
	</nav>

	<fieldset id = "sBar" >
		<legend>Search Film By Title</legend>
	<!-- This form will submit a GET request to the "FindFilmByTitle" resource -->
		<form method="GET" action="FindFilmByTitle">
			<label>Title: <input type="text" name="titlef"
				placeholder="Search Film..." />
				<button type="submit">
				<!-- Class is an Bootstrap Icon -->
				<i class="bi bi-search"></i>
				</button>
			</label>
		</form>
	</fieldset>

	<!-- This is a table to display the films -->
	
	

	<div class="col-12 mt-5">
		<table class="table table-hover table-dark">
			<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Year</td>
					<td>Director</td>
					<td>Stars</td>
					<td>Reviews</td>
				</tr>
			</thead>
			<tbody class="film-list">
			<!-- This is a JSP tag to iterate over a collection of items -->
				<f:forEach items="${film}" var="f">
					<tr id = "list-of-films">
						<th><b> ${f.id}</b></th>
						<th><b> ${f.title}</b></th>
						<th><b> ${f.year}</b></th>
						<th><b> ${f.director}</b></th>
						<th><b> ${f.stars}</b></th>
						<th><em>${f.review}</em></th>
						<th>
						<!-- This is a form to submit a GET request to the "updateFilms" resource -->
							<form method="GET" action="./updateFilms">
								<input type="hidden" value="${f.id}" name="id" />
								<button  class="btn btn-warning btn-sm edit">
								<i class="bi bi-pencil-square"></i>	

								</button>
							</form>
						</th>
						<th>
							<!-- This is a form to submit a POST request to the "deleteFilm" resource -->
							<form method="POST" action="./deleteFilm">
								<input type="hidden" value="${f.id}" name="id"/>
								<button class="btn btn-danger btn-sm delete">
								<i class="bi bi-trash"></i>
								</button>
							</form>

						</th>
						<th>
							<!-- This is a form to submit a POST request to the "addFilms.jsp" resource -->
							<form method="POST" action="addFilms.jsp">
								<button class="btn btn-success add-btn">
								<i class="bi bi-plus-circle-fill"></i>
								</button>
							</form>
						</th>
					</tr>
				</f:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>
