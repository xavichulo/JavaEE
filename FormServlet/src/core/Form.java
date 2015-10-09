package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//Create PrintWriter for output HTML
		PrintWriter out = response.getWriter();
		
		//Define HTML webpage
		response.setContentType("text/html");
		
		out.println("<html>");
        out.println("<head></head>");         
        out.println("<body>");
        
        //obtain parameters with name in HTML
        String u = request.getParameter("user");
        String p = request.getParameter("pswd");
        
        if(u.length()==0 || p.length()==0){
        	
        	out.println("User or password incorrect");
        }
        
        
        //Print parameters.
        else{
        out.println("<br> User:  "+u);
        out.println("<br> Password:  "+p);
        
        out.println("</body>");
        out.println("</html>");
        }
	}

}