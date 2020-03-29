package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Pais;
import Service.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// PEGAR TUDO QUE ESTA NO FORMULARIO E GUARDAR DENTRO DE UMA STRING
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		
		//CRIAR O OBJETO DENTRO DA CLASSE PAIS
		Pais paises = new Pais();
		paises.setNome(pNome);
		paises.setPopulacao(Long.parseLong(pPopulacao));
		paises.setArea(Double.parseDouble(pArea));
		
		PaisService tt = new PaisService();
		tt.criar(paises);
		tt.carregar(paises.getId());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title> FINALIZAÇÃo </title></head><body>");
		out.println("<h1> PAÍS CADASTRADO!</h1>");
		out.println("<b>ID: </b>"+paises.getId()+ "<br>");
		out.println("<b>Nome: </b>"+paises.getNome()+ "<br>");
		out.println("<b>População: </b>"+paises.getId()+ "<br>");
		out.println("<b>Área: </b>"+paises.getArea()+ "<br>");
	    out.println("</body></html>");
		


}}
