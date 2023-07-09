package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.FilmDAO;
import model.Film;

@WebServlet("/deleteFilm")
public class deleteFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteFilm() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create a new Film object
		Film f = new Film();
		// Set the ID of the Film object to the value of the "id" parameter from the
		// request
		f.setId(Integer.valueOf(request.getParameter("id")));

		// Create a new FilmDAO object
		FilmDAO dao = new FilmDAO();

		// Print the ID of the Film object to the console
		System.out.println(f.getId());
		// Print the Film object to the console
		System.out.println(f);

		// Try to delete the Film object from the database
		try {
			dao.deleteFilm(f);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}


		HttpSession session = request.getSession();
		session.setAttribute("message", "Data deleted");

		// Redirect the user to another resource on the server
		response.sendRedirect("./getAllFilms");
	}

}
