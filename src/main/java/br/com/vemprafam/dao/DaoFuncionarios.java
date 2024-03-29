package br.com.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.vemprafam.pojo.Funcionario;

public class DaoFuncionarios {
	private String user = "SA";
	private String password = "";
	private String url = "jdbc:hsqldb:hsql://localhost/";
	private Connection connection;

	public DaoFuncionarios() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void inserir(Funcionario funcionarios) {

		try {
			String sql = "INSERT INTO FUNCIONARIOS VALUES(?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, funcionarios.getRe());
			pstmt.setString(2, funcionarios.getNome());
			pstmt.setDate(3,
					new java.sql.Date(funcionarios.getDataAdmissao().getTime()));
			pstmt.setDouble(4, funcionarios.getSalario());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Funcionario> getLista() {
		List<Funcionario> result = new ArrayList<Funcionario>();

		try {
			String sql = "SELECT re, nome, dataAdmissao, salario from Funcionarios";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while ( rs.next() ) {
				int re = rs.getInt(1);
				String nome = rs.getString("nome");
				Date DataAdmissao = rs.getDate("dataAdmissao");
				double salario = rs.getDouble("salario");
				Funcionario Funcionario = new Funcionario(re, nome, DataAdmissao, salario);
				result.add(Funcionario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Funcionario buscarPeloRe(int re) {
		return null;
	}

	public void atualizar (Funcionario funcionario) {
		try {
			String sql = "UPDATE Funcionarios SET nome=?, dataAdmissao=?, salario=? WHERE re=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setDate(2,
					new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(3, funcionario.getSalario());
			pstmt.setInt(4, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	public void excluir(Funcionario funcionarios) {
		try {
			String sql = "DELETE FROM FUNCIONARIOS WHERE RE = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, funcionarios.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DaoFuncionarios dao = new DaoFuncionarios();
		dao.atualizar(new Funcionario(544, "Roberto", new Date(), 1500));


	}
}