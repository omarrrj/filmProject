package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import model.Film;


@WebServlet("/FindFilmByTitle")
public class FindFilmByTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FindFilmByTitle() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("titlef");
		System.out.println(title);
		FilmDAO dao = new FilmDAO();
		// Get a list of Film objects with the specified title from the database
		ArrayList<Film> titlef = dao.getFilmByTitle(title);
		// Set the list of Film objects as an attribute of the request object
				request.setAttribute("film", titlef);
		System.out.println(titlef);

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);

	}
}
