package state.Login.Servlet;

import java.io.IOException;

import state.Login.connection.*;

import java.sql.*;

import java.io.*;

import javax.servlet.http.HttpSession;
import javax.servlet.*;

import javax.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class STATE_Login_Servlet
 */
@WebServlet("/STATE_Login_Servlet")
public class STATE_Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public STATE_Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html");
	    String STATE_USER_NAME = request.getParameter("userNameSTATE");
	    String STATE_PASS = request.getParameter("userPassSTATE");
	    
	    State_Login obj = new State_Login ();
	    
	    ResultSet RS = null;
	    
	    RS = obj.stateLogin(STATE_USER_NAME, STATE_PASS);
	    
	    HttpSession session = request.getSession(true);
	    
	    
	    try {
            if (!RS.next()){
                RS.beforeFirst();
                response.sendRedirect("###");
            }else {
                
                
               
                session.setAttribute("STATE_Sign",RS.getString(1));
                session.setAttribute("Officer_Name",RS.getString(2));
                session.setAttribute("State_Name", RS.getString(3));
                session.setAttribute("Officer_Email",RS.getString(4));
                response.sendRedirect("http://localhost:8080/PMAY/PMAY-U/ImplementationAgency/ULB_LoggedIn.jsp");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
