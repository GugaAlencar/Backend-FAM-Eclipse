package br.com.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoAluno;

/**
 * Servlet implementation class PrimeiraServlet
 */
@WebServlet("/PrimeiraServlet")
public class PrimeiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimeiraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    DaoAluno dao= new DaoAluno();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Teste</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<p>página de teste</p>\r\n"
				+ dao.getLista()
				+ "</body>\r\n"
				+ "</html>");
		System.out.println("Esse texto vai para o console");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
