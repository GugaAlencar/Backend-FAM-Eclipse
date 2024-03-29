package br.com.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoAluno;
import br.com.vemprafam.pojo.Aluno;

/**
 * Servlet implementation class ServeletCadastro
 */
@WebServlet("/cadastrarAluno")
public class ServeletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int ra = Integer.parseInt (request.getParameter("ra"));
		String nome = request.getParameter("nome");
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento;
		try {
			dataNascimento = dateformat.parse(request.getParameter("dataNascimento"));
		} catch (ParseException e) {
			dataNascimento = new Date();
		}

		double renda = Double.parseDouble(request.getParameter("renda"));
		DaoAluno dao = new DaoAluno();
		dao.inserir(new Aluno(ra,nome,dataNascimento,renda));
		out.println("inserido");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
