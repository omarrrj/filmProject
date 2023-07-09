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

@WebServlet("/addFilm")
public class addFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create a new Film object
		Film film = new Film(String.valueOf(request.getParameter("title")),
				Integer.valueOf(request.getParameter("year")), String.valueOf(request.getParameter("director")),
				String.valueOf(request.getParameter("stars")), String.valueOf(request.getParameter("review")));

		// Create a new FilmDAO object
		FilmDAO dao = new FilmDAO();

		// Try to insert the film into the database
		try {
			dao.insertFilm(film);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		request.setAttribute("response", "Film added");
		RequestDispatcher rd = request.getRequestDispatcher("addFilms.jsp");
		rd.include(request, response);
	}

}
