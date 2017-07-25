package controle;

import java.util.List;

import modelo.Usuario;
import dao.DAOFactory;
import dao.UsuarioDao;

public class UsuarioControle {

	public void salvar(Usuario usuario, String confirmarSenha) throws Exception {
		if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
			throw new Exception("� necess�rio inserir um nome de usu�rio!");
		}
		if (usuario.getDataNascimento() == null) {
			throw new Exception("� necess�rio inserir uma data de nascimento do usu�rio!!");
		}
		if (usuario.getCpf() == null || usuario.getCpf().trim().length() != 14) {
			throw new Exception("� necess�rio inserir um cpf para o usu�rio!");
		}
		if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
			throw new Exception("� necess�rio inserir um e-mail para o usu�rio!");
		}
		if (usuario.getCidade() == null || usuario.getCidade().trim().isEmpty()) {
			throw new Exception("� necess�rio inserir uma cidade onde se localiza o usu�rio!");
		}
		if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
			throw new Exception("� necess�rio inserir uma senha para o usu�rio!");
		} else if (usuario.getSenha().trim().length() != 8) {
			throw new Exception("1234abcd (Senha deve ter 8 caracteres)");
		} else if (!usuario.getSenha().equals(confirmarSenha)) {
			throw new Exception("� necess�rio confirmar a senha escolhida!");
		}

		UsuarioDao usuarioDao = DAOFactory.getUsuarioDao();
		// substituir email por usuarioLogin(Arthur)
		Usuario email = usuarioDao.buscarPorEmail(usuario.getEmail());
		if (email != null
				&& (usuario.getIdUsuario() == 0 || (usuario.getIdUsuario() != 0 && usuario
						.getIdUsuario() != email.getIdUsuario()))) {
			throw new Exception("Email j� cadastrado!");
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
