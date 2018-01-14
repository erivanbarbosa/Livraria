package servico;

import java.util.Collection;

import dao.LivroDao;
import modelo.Livro;

//Classe LivroServico mant�m as regras de neg�cio do programa.
public class LivroServico {
	private LivroDao dao = new LivroDao();
	
	//M�todo listar todos chama o m�todo listar da classe LivroDao
	public Collection<Livro> listarTodos() {
		return dao.listar();
	}
}
