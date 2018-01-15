package SwingView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Livro;
import servico.LivroServico;

public class PesquisarLivrosTela extends JPanel {

	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT) );
	JPanel panelButton = new JPanel();
	
	public PesquisarLivrosTela() {

		// Cria o combobox de opções
		String[] opcoes = { "Selecione", "Listar Todos" };
		JComboBox<String> combo = new JComboBox<String>(opcoes);
		combo.setSelectedIndex(0);
		panel.add(combo);

		// Cria a tabela
		String[] colunas = new String[] { "Título", "Autor", "Preço" };
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colunas);

		JTable tabela = new JTable(modelo);
		JScrollPane barraRolagem = new JScrollPane(tabela);
		tabela.setBackground(Color.WHITE);
		barraRolagem.setPreferredSize(new Dimension(410, 205));
		panel.add(barraRolagem);

		
		// Adiciona o botão de busca
		JButton buscarButton = new JButton("Buscar");
		panelButton.add(buscarButton);
		panelButton.setPreferredSize(new Dimension(410, 40));
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(panelButton);
		panel.setPreferredSize(new Dimension(415, 348));

		// Adiciona o action listener do botão de busca
		buscarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (combo.getSelectedItem() == "Listar Todos") {
					LivroServico servico = new LivroServico();
					ArrayList<Livro> livros = (ArrayList<Livro>) servico.listarTodos();
					
					for (Livro livro : livros) {
						Object[] linha = new Object[] { livro.getTitulo(), livro.getAutor(), livro.getPreco() };
						modelo.addRow(linha);
					}
				}

			}
		});
		
		this.add(panel);
	}
}
