package br.com.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoFuncionarios;
import br.com.vemprafam.pojo.Aluno;
import br.com.vemprafam.pojo.Funcionario;


/**
 * Servlet implementation class ServeletTabelaFuncionarios
 */
@WebServlet("/ServeletTabelaFuncionarios")
public class ServeletTabelaFuncionarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletTabelaFuncionarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DaoFuncionarios dao = new DaoFuncionarios();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Tabela</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<table border='1'>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "<tr>\r\n"
				+ "	<th> Re </th>\r\n"
				+ "	<th> nome</th>\r\n"
				+ "	<th> dataadmissao</th>\r\n"
				+ "	<th> Salario </th>\r\n"
				+ "</tr>\r\n");

		List<Funcionario> lista = dao.getLista();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

		for(Funcionario a:lista) {
			out.println( "<tr>\r\n"
			+ "\r\n"
			+ "<td> "+a.getRe()+"</td>\r\n"
			+ "<td> "+a.getNome()+" </td>\r\n"
			+ "<td> "+dateFormat.format(a.getDataAdmissao())+" </td>\r\n"
			+ "<td> "+numberFormat.format(a.getSalario())+" </td>\r\n"
			+ "\r\n"
			+ "</tr>\r\n");
			}
			out.println("</table>\r\n"
			+ "\r\n"
			+ "</body>\r\n"
			+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
