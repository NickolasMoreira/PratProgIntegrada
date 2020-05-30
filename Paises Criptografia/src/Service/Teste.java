package Service;

import criptografia.CryptoMethod;
import Modelo.Usuario;
import Service.PaisService;

public class Teste {
public static void main(String[] args) {
	
	Usuario user = new Usuario();
	PaisService ps = new PaisService();
	CryptoMethod c = new CryptoMethod();
	String usuario = "pratprog";
	String teste = "1234";
	user = ps.logar(usuario);
	
	try {
		String recebe= c.criptografa(teste);
		System.out.println("criptografada: "+ recebe);
		System.out.println(user.getSenha());
		
		if(recebe.equals(user.getSenha())) {
			System.out.println("iguais");
		}
		else {
			System.out.println("diferentes");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
		

}
}