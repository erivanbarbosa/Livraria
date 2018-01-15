package SwingView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PrincipalTela {

	JFrame frame = new JFrame("Pesquisar Livros");
	JPanel panelPrincipal;
	
	public void exibir() {
		
		// Adiciona o icone da barra superior
		Image icon = Toolkit.getDefaultToolkit().getImage("book.png");
		frame.setIconImage(icon);

		// Adiciona imagem de fundo do painel principal
		panelPrincipal = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image imagem = new ImageIcon("principal.jpg").getImage();
				g.drawImage(imagem, 0, 0, 411, 280, this);
			}
		};
		panelPrincipal.setPreferredSize(new Dimension(415, 348));
		
		//Cria o compras
		JMenu menuArquivo = new JMenu("Compras");
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();				
			}
		});
		menuArquivo.add( sair );
		
		//Cria o menú livros
		JMenu menuLivros = new JMenu("Livros");
		JMenuItem pesquisar = new JMenuItem("Pesquisar");
		pesquisar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
                frame.getContentPane().add(new PesquisarLivrosTela());//Adding to content pane, not to Frame
                frame.repaint();
                frame.printAll(frame.getGraphics());//Extort print all content
				
			}
		});
		
		// Cria a barra de menú e adiciona os itens
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuArquivo);
		menuBar.add(menuLivros);
		
		frame.setJMenuBar(menuBar);
		frame.setLayout(new FlowLayout());
		frame.add(panelPrincipal);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(440, 350);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
