package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import modelo.Livro;

public class LivroDao {
	
	// Nova versão do método listar, abre e lê o arquivo "livros.csv"
	public Collection<Livro> listar() {
		ArrayList<Livro> livros = new ArrayList<Livro>();
		Scanner input = null;
		try {

			input = new Scanner(new File("livros.csv"));
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado!");
			System.exit(1);
		}

		while (input.hasNext()) {
			String line = input.nextLine();
			
			//Divide a linha lida em 3 substring, usando a virgula como caractere separador.
			// Expressao regular ignora virgulas entre aspas.
			String[] palavras = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			Livro livro = new Livro();
			livro.setTitulo(palavras[0]);
			livro.setAutor(palavras[1]);
			livro.setPreco(Double.parseDouble(palavras[2]));

			livros.add(livro);
		}

		return livros;
	}
}
