package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.LoginDao;

/**
 * Servlet implementation class ValidadorServlett
 */
public class ValidadorServlett extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidadorServlett() {
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
        String Username, Password, msg = "";
        
        Username = request.getParameter("Username");
        Password = request.getParameter("Password");
        
        try {
        	if(LoginDao.validar(Username, Password) == 1) {
        		msg = "Usuario y contraseña correctos";
        	}else {
        		msg= "Revise su usuario o contraseña";
        	}
        }catch( Exception e) {
        	e.printStackTrace();
        	msg = "Error al validad: " + e.getMessage();
        }
        
        System.out.println("Resultado de validar: " + LoginDao.validar(Username, Password));
        
        RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");
        request.setAttribute("mensaje", msg);
        despachador.forward(request, response);
    }

}
