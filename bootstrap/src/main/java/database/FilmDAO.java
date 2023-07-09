package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Film;


public class FilmDAO {

	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
	String user = "jeylaano";
    String password = "swIghuth2";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

	public FilmDAO() {}


	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver");
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return thisFilm;
	}



   public ArrayList<Film> getAllFilms(){

		ArrayList<Film> allFilms = new ArrayList<>();
		openConnection();

	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   public Film getFilmByID(int id){

		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }

   public ArrayList<Film> getFilmByTitle(String title){
	   ArrayList<Film> titlef = new ArrayList<>();

	   openConnection();
	   oneFilm=null;
	   // Create select statement and execute it
	   try{
		   String selectSQL = "select * from films where title LIKE '%"+title+"%'";
		   ResultSet rs1 = stmt.executeQuery(selectSQL);
		   // Retrieve the results
		   while(rs1.next()){
			   oneFilm = getNextFilm(rs1);
			   System.out.println(oneFilm.getTitle());
			   titlef.add(oneFilm);
		   }

		   stmt.close();
		   closeConnection();
	   } catch(SQLException se) { System.out.println(se); }

	   return titlef;
   }

public Film getFilmByYear(int year){

	   openConnection();
	   oneFilm=null;
	   // Create select statement and execute it
	   try{
		   String selectSQL = "select * from films where title LIKE '%"+year+"%';";
		   ResultSet rs1 = stmt.executeQuery(selectSQL);
		   // Retrieve the results
		   while(rs1.next()){
			   oneFilm = getNextFilm(rs1);
		   }

		   stmt.close();
		   closeConnection();
	   } catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }

public Film getFilmByDirector(String director){

	   openConnection();
	   oneFilm=null;
	   // Create select statement and execute it
	   try{
		   String selectSQL = "select * from films where title LIKE '%"+director+"%';";
		   ResultSet rs1 = stmt.executeQuery(selectSQL);
		   // Retrieve the results
		   while(rs1.next()){
			   oneFilm = getNextFilm(rs1);
		   }

		   stmt.close();
		   closeConnection();
	   } catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
}

public Film getFilmByReview(String review){

	   openConnection();
	   oneFilm=null;
	   // Create select statement and execute it
	   try{
		   String selectSQL = "select * from films where title LIKE '%"+review+"%';";
		   ResultSet rs1 = stmt.executeQuery(selectSQL);
		   // Retrieve the results
		   while(rs1.next()){
			   oneFilm = getNextFilm(rs1);
		   }

		   stmt.close();
		   closeConnection();
	   } catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
}

   public void insertFilm (Film f) throws SQLException {
	   openConnection();
	   try {
		   //This is the SQL statement
			String insertSql = "INSERT into films (id, title,year,director,stars,review) VALUES ('" + f.getId() + "','" + f.getTitle() + "','" + f.getYear() +"','" +f.getDirector()+"','" +f.getStars()+"','"+f.getReview() +"');";
			// Print the sql to the console
			System.out.println(insertSql);
			//execute the sql statement
			stmt.executeUpdate(insertSql);
			//close the connection and statement
			closeConnection();
			stmt.close();
		} catch (SQLException s) {
			//print the stacktrace of the SQL Exception
			s.printStackTrace();
		}

	}

   public boolean updateFilm(Film f) throws SQLException {
	   openConnection();
	   boolean b = false;

	   try {
		   //SQL Statement for Update
			String updateSql = "UPDATE films"
						+ " SET title = '" + f.getTitle() + "',"
						+ "year = " +f.getYear()+","
						+ "director = '" +f.getDirector()+"',"
						+ "stars = '" +f.getStars()+"',"
						+ "review = '" +f.getReview()+"' "
						+ "WHERE id = " + f.getId() + ";"
						;

			System.out.println(updateSql);
			stmt.executeUpdate(updateSql);
			closeConnection();
			stmt.close();
		} catch (SQLException s) {
			throw new SQLException("Film Not Updated");
		}
	   return b;
   }

   public void deleteFilm (Film f) throws SQLException {
	   openConnection();
	   try {
		   //SQL statement for delete
			String deleteSql = "DELETE from films WHERE id = '" + f.getId() + "';";
			System.out.println(deleteSql);
			stmt.executeUpdate(deleteSql);

			closeConnection();
			stmt.close();
		} catch (SQLException s) {
			throw new SQLException("Film Not Deleted");
		}
   }




}
