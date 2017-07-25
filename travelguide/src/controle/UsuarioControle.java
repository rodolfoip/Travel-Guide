package controle;

import java.util.List;

import modelo.Usuario;
import dao.DAOFactory;
import dao.UsuarioDao;

public class UsuarioControle {

	public void salvar(Usuario usuario, String confirmarSenha) throws Exception {
		if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
			throw new Exception("É necessário inserir um nome de usuário!");
		}
		if (usuario.getDataNascimento() == null) {
			throw new Exception("É necessário inserir uma data de nascimento do usuário!!");
		}
		if (usuario.getCpf() == null || usuario.getCpf().trim().length() != 14) {
			throw new Exception("É necessário inserir um cpf para o usuário!");
		}
		if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
			throw new Exception("É necessário inserir um e-mail para o usuário!");
		}
		if (usuario.getCidade() == null || usuario.getCidade().trim().isEmpty()) {
			throw new Exception("É necessário inserir uma cidade onde se localiza o usuário!");
		}
		if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
			throw new Exception("É necessário inserir uma senha para o usuário!");
		} else if (usuario.getSenha().trim().length() != 8) {
			throw new Exception("1234abcd (Senha deve ter 8 caracteres)");
		} else if (!usuario.getSenha().equals(confirmarSenha)) {
			throw new Exception("É necessário confirmar a senha escolhida!");
		}

		UsuarioDao usuarioDao = DAOFactory.getUsuarioDao();
		// substituir email por usuarioLogin(Arthur)
		Usuario email = usuarioDao.buscarPorEmail(usuario.getEmail());
		if (email != null
				&& (usuario.getIdUsuario() == 0 || (usuario.getIdUsuario() != 0 && usuario
						.getIdUsuario() != email.getIdUsuario()))) {
			throw new Exception("Email já cadastrado!");
		}
		if (usuario.getIdUsuario() == 0) {
			usuarioDao.salvar(usuario);
		} else {
			usuarioDao.alterar();
		}
	}

	public void excluir(Usuario usuario) {
		UsuarioDao usuarioDao = DAOFactory.getUsuarioDao();
		usuarioDao.excluir(usuario);
	}

	public List<Usuario> listarTodos() {
		UsuarioDao usuarioDao = DAOFactory.getUsuarioDao();
		return usuarioDao.listarTodos();
	}

	public Usuario efetuarLogin(String email, String senha) {
		UsuarioDao usuarioDao = DAOFactory.getUsuarioDao();
		return usuarioDao.efetuarLogin(email, senha);
	}

}
