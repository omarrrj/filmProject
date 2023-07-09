<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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

<title>Update</title>
</head>
<body id = "body">

	<div class="container mt-5">
		<div class="text-center">
			<h1 class="display-5 mb-5">
				<strong>Update A Film</strong>
			</h1>
		</div>
		
		 <%
			if(request.getAttribute("response") != null){
				
		%>
				<p>Film updated successfully</p>
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

	<div class="main row justify-content-center">
    <form action="./updateFilms" method="POST" class="row justify-content-center mb-4" >
        <div class="col-10 mb-3">
            <label for="title">Title</label>
            <input class="form-control" id="title" type="text" name="title" value="${film.title}" placeholder="Enter Title...">
        </div>
        <div class="col-10 mb-3">
            <label for="year">Year</label>
            <input class="form-control" type="text" name="year" value="${film.year}" placeholder="Enter Year...">
        </div>
        <div class="col-10 mb-3">
            <label for="director">Director</label>
            <input class="form-control" type="text" name="director" value="${film.director}" placeholder="Enter Director...">
        </div>
        <div class="col-10 mb-3">
            <label for="stars">Stars</label>
            <input class="form-control" type="text" name="stars" value="${film.stars}" placeholder="Enter Stars...">
        </div>
        <div class="col-10 mb-3">
            <label for="review">Review</label>
            <input class="form-control" type="text" name="review" value="${film.review}" placeholder="Enter Review...">
        </div>
        <div class="col-10">
           	<input type="hidden" name="id" value="${film.id}">
            <input class="btn btn-success add-btn" type="submit" value="Update">
        </div>
    </form>
</div>


	

</nav>


</body>
</html>