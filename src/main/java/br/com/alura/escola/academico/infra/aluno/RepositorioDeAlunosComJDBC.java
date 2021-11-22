package br.com.alura.escola.academico.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.academico.dominio.aluno.repository.RepositorioDeAlunos;
import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.academico.dominio.aluno.exception.AlunoNaoEncontrado;
import br.com.alura.escola.academico.dominio.aluno.vo.Email;
import br.com.alura.escola.academico.dominio.aluno.vo.Telefone;
import br.com.alura.escola.shared.domain.vo.CPF;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

	private final Connection connection;
	
	public RepositorioDeAlunosComJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(AlunoAggregate aluno) {
		try {
			String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf().getNumero());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			for (Telefone telefone : aluno.getTelefones()) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumero());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public AlunoAggregate buscarPorCPF(CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());

			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new AlunoNaoEncontrado(cpf);
			}

			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			AlunoAggregate encontrado = new AlunoAggregate(cpf, nome, email);
			
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				encontrado.adicionarTelefone(ddd, numero);
			}
			
			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<AlunoAggregate> listarTodosAlunosMatriculados() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<AlunoAggregate> alunos = new ArrayList<>();
			while (rs.next()) {
				CPF cpf = new CPF(rs.getString("cpf"));
				String nome = rs.getString("nome");
				Email email = new Email(rs.getString("email"));
				AlunoAggregate aluno = new AlunoAggregate(cpf, nome, email);
				
				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					String numero = rsTelefone.getString("numero");
					String ddd = rsTelefone.getString("ddd");
					aluno.adicionarTelefone(ddd, numero);
				}
			
				alunos.add(aluno);
			}
			
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}