package dao;

import java.util.ArrayList;
import java.util.Collection;


import modelo.Livro;

public class LivroDao {
	public Collection<Livro> listar() {
		ArrayList<Livro> livros = new ArrayList<Livro>();

		for (int i = 0; i < 50; i++) {
			Livro livro = new Livro();
			livro.setTitulo("Livro" + i);
			livro.setAutor("Autor " + 1);
			livro.setPreco(i * 0.80 + 20);

			livros.add(livro);
		}

		return livros;
	}
}
