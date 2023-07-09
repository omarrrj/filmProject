<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Custom style sheet -->
<link rel="stylesheet" href="css/stylesheet.css">
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Bootstrap Icon CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">



<title>Add A Film</title>
</head>
<body id="body">

	<div class="container mt-5">
		<div class="text-center">
			<h1 class="display-5 mb-5">
				<strong>Add A Film</strong>
			</h1>
		</div>
		<%
		if (request.getAttribute("response") != null) {
		%>
		<p id="success-message">Film added successfully</p>
		<%
		}
		%>
	</div>

	<nav>
		<ul>
			<li><a href="./getAllFilms">Home</a></li>
			<li><a href="#">Films</a></li>
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">About Us</a></li>
		</ul>
	</nav>

	<div class="main row justify-content-center">
		<form id="addfilm" action="./addFilm" method="POST"
			class="row justify-content-center mb-4">
			<div class="col-10 mb-3">
				<label for="title">Title</label> <input class="form-control"
					type="text" name="title" placeholder="Enter Title...">
			</div>
			<div class="col-10 mb-3">
				<label for="year">Year</label> <input class="form-control"
					type="text" name="year" placeholder="Enter Year...">
			</div>
			<div class="col-10 mb-3">
				<label for="director">Director</label> <input class="form-control"
					type="text" name="director" placeholder="Enter Director...">
			</div>
			<div class="col-10 mb-3">
				<label for="stars">Stars</label> <input class="form-control"
					type="text" name="stars" placeholder="Enter Stars...">
			</div>
			<div class="col-10 mb-3">
				<label for="review">Review</label> <input class="form-control"
					type="text" name="review" placeholder="Enter Review...">
			</div>
			<div class="col-10">
				<input class="btn btn-success add-btn" type="submit" value="Add">
			</div>
		</form>
	</div>


</body>
</html>