package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import model.Film;

@WebServlet("/updateFilms")
public class updateFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateFilms() {
		super();
	}

	// This method handles HTTP GET requests
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create a new FilmDAO object
		FilmDAO dao = new FilmDAO();
		// Create a new Film object

		// Get the "id" parameter from the request
		String fid = request.getParameter("id");
		// Convert the "id" parameter to an integer
		int idf = Integer.parseInt(fid);
		System.out.println(fid);
		Film film = dao.getFilmByID(idf);
		// Set the Film object as an attribute of the request object
		request.setAttribute("film", film);
		// Get the RequestDispatcher object for the "updateFilms.jsp" resource
		RequestDispatcher rd = request.getRequestDispatcher("updateFilms.jsp");
		// Include the specified resource in the response to the client
		rd.include(request, response);
	}

	// This method handles HTTP POST requests
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create a new FilmDAO object
		FilmDAO dao = new FilmDAO();
		// Create a new Film object
		Film f = new Film();
		f.setId(Integer.parseInt(request.getParameter("id")));
		f.setTitle(request.getParameter("title"));
		f.setYear(Integer.parseInt(request.getParameter("year")));
		f.setDirector(request.getParameter("director"));
		f.setStars(request.getParameter("stars"));
		f.setReview(request.getParameter("review"));
		String review = request.getParameter("review");
		// Print the "review" parameter to the console
		System.out.println(review);
		// Try to update the Film object in the database
		try {
			dao.updateFilm(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Redirect the user to another resource on the server
		request.setAttribute("response", "Film updated");
		//response.sendRedirect("./getAllFilms");
		RequestDispatcher rd = request.getRequestDispatcher("updateFilms.jsp");
		rd.include(request, response);
	}
}
