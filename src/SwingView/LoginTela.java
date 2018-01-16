package SwingView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import servico.LoginServico;

public class LoginTela extends JPanel {

	JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER) );
	JPanel panelButton = new JPanel();
	JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER) );
	JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.CENTER) );
	JPanel panelSenha = new JPanel(new FlowLayout(FlowLayout.CENTER) );
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image imagem = new ImageIcon("principal.jpg").getImage();
		g.drawImage(imagem, 0, 0, 411, 280, this);
	}
	
	public LoginTela() {
		
		this.setPreferredSize((new Dimension(415, 348)));
		


		
		JLabel loginLabel = new JLabel("Login");
		Font fonteTitulo = new Font(null, Font.PLAIN, 40);
		
		loginLabel.setFont(fonteTitulo);
		panelTitulo.setPreferredSize(new Dimension(415, 60));
		panelTitulo.setMinimumSize(new Dimension(415, 60));
		panelTitulo.setBackground(new Color(0,0,0,0));
		panelTitulo.add(loginLabel);
		this.add(panelTitulo);
		
		JLabel usuarioLabel = new JLabel("Usuario");
		JTextField usuarioTextField = new JTextField(20);
		
		panelUsuario.setPreferredSize(new Dimension(415, 30));
		panelUsuario.add(usuarioLabel);
		panelUsuario.add(usuarioTextField);
		panelUsuario.setBackground(new Color(0,0,0,0));
		this.add(panelUsuario);
		
		
		JLabel senhaLabel = new JLabel("Senha  ");
		JPasswordField senhaField = new JPasswordField(20);
		
		panelSenha.setPreferredSize(new Dimension(415, 30));
		panelSenha.add(senhaLabel);
		panelSenha.add(senhaField);
		panelSenha.setBackground(new Color(0,0,0,0));
		this.add(panelSenha);
		
		// Adiciona o botão de busca
		JButton loginButton = new JButton("Buscar");
		JButton sairButton = new JButton("Sair"); 
		
		
		panelButton.setPreferredSize(new Dimension(200, 40));
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelButton.setBackground(new Color(0,0,0,0));
		panelButton.add(loginButton);
		panelButton.add(sairButton);
		this.add(panelButton);



		// Adiciona o action listener do botão de busca
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginServico servico = new LoginServico();
				
				if(servico.autenticar(usuarioTextField.getText(), senhaField.getText())) {
					PrincipalTela.login();
				} else {
					JOptionPane.showMessageDialog(panelUsuario , "Usuário e/ou senha incorretos");
				}
				
				
			}
		});
		
		
		// Adiciona o action listener do botão de busca
				sairButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						PrincipalTela.fecharFrame();
					}
				});
	/*	this.add(panel);*/
	}
}

