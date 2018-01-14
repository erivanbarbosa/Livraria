package servico;

import java.util.Collection;

import dao.LivroDao;
import modelo.Livro;

//Classe LivroServico mantém as regras de negócio do programa.
public class LivroServico {
	private LivroDao dao = new LivroDao();
	
	//Método listar todos chama o método listar da classe LivroDao
	public Collection<Livro> listarTodos() {
		return dao.listar();
	}
}
