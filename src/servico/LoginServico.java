package servico;

public class LoginServico {
	public boolean autenticar(String login, String senha ) {
		boolean resultado = false;
		
		if(login.equals("admin") && senha.equals("admin") ) {
			resultado = true;
		}
		
		return resultado;
	}
}
