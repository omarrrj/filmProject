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




@WebServlet("/getAllFilms")
public class getAllFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public getAllFilms() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a new FilmDAO object
		FilmDAO dao = new FilmDAO();
		// Get a list of all Film objects from the database
		ArrayList<Film> allFilms = dao.getAllFilms();
		// Set the list of Film objects as an attribute of the request object
		request.setAttribute("film", allFilms);
		request.setAttribute("response", "Data");


		// Get the RequestDispatcher object for the "index.jsp" resource
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);

	}




}
