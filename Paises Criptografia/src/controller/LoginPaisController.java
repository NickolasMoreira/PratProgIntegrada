package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.Usuario;
import Service.PaisService;
import criptografia.CryptoMethod;

/**
 * Servlet implementation class LoginPaisController
 */
@WebServlet("/login_pais.do")
public class LoginPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String pUsuario = request.getParameter("usuario");
		String pSenha =request.getParameter("senha");
		String pAcao = request.getParameter("acao");
		
		
		PaisService ps = new PaisService();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		Usuario user = new Usuario();
		user = ps.logar(pUsuario);
		CryptoMethod c = new CryptoMethod();

		user = ps.logar(pUsuario);
		
		try {
			String criptografa = c.criptografa(pSenha);
			System.out.println("criptografada: "+ criptografa);
			System.out.println(user.getSenha());
			
			
			if(criptografa.equals(user.getSenha())) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				File arquivo = new File("C:\\Users\\MOREIRA\\Desktop\\FACULDADE\\dsa\\Pais\\Paises Criptografia\\WebContent\\log","key.txt");
				FileOutputStream outFileStream = new FileOutputStream(arquivo);
				PrintWriter outStream = new PrintWriter(outFileStream);
				outStream.println("O usuário "+"" + pUsuario +""+ " entrou!"+ "\n");
				outStream.println(getDateTime());
				outStream.println("Senha inserida: "+" "+pSenha);
				outStream.println("Senha inserida criptograda: "+" "+criptografa);
				outStream.close();
			}
			else {
				File arquivo = new File("C:\\Users\\MOREIRA\\Desktop\\FACULDADE\\dsa\\Pais\\Paises Arquivos\\WebContent\\log","LogError.txt");
				FileOutputStream outFileStream = new FileOutputStream(arquivo);
				PrintWriter outStream = new PrintWriter(outFileStream);
				outStream.println("O usuário "+""+ pUsuario +" "+" tentou login mas sem sucesso"+ "\n");
				outStream.println("Login ou senha inválida!");
				outStream.println(getDateTime());
				outStream.close();
				response.sendRedirect("login.jsp");  
				System.out.println("diferentes");
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
	}
	private String getDateTime(){ 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
	
}
