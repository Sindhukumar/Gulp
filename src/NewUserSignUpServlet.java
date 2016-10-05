

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tool.Ruser;
import Util.DbUser;


/**
 * Servlet implementation class NewUserSignUpServlet
 */
@WebServlet("/NewUserSignUpServlet")
public class NewUserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserSignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");
		String zip = request.getParameter("zip");
		
		Ruser addNew = new Ruser();
		
		addNew.setUsername(username);
		addNew.setUseremail(useremail);
		addNew.setUserpassword(password);
		addNew.setZip(zip);
		addNew.setUserrole("user");
		
		System.out.println("Add new grade details");
		DbUser.insert(addNew);
		
		String nextURL = "/Home.jsp";
		response.sendRedirect(request.getContextPath()+nextURL);
		
		
	}

}
