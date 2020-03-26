package br.usjt.paises;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class PaisTeste {
	
	Pais paises,copia;
	static int id = 0;
	static long populacao;
	static double area;
	static String nome;
	
	@Before
	public void setUp() throws Exception {
		//System.out.println("\nsetup");
		paises = new Pais(id, "Brazil", 1246700, 12878.00);
		copia = new Pais(id, "Brazil", 1246700, 12878.00);
		
	
	}
	
	
	@Test
	
	public void testeCriar() {
		
		System.out.println("");
		System.out.println("*** TESTE CRIAR ***");
		System.out.println("");
		
		paises.criar();       //CRIAA NO BD
		id = paises.getId();  // PEGA O ID DO OBJETO E PAISES E ARMAZENA EM ID
		copia.setId(id);      // PEGA O OBJETO COPIA E SETA O MESMO ID DO OBJETO PAISES
		copia.carregar();	   //CARREGA DO BANCO O OBJETO CÓPIA QUE POSSUI ID DE PAISES	
		
		System.out.println("Esperado:      " + paises);
		System.out.println("Pais Carregado: " + copia);
		System.out.println("");
		System.out.println("******************");
		
		assertEquals("teste criar", paises, copia);
		
		
	}
	
	
	@Test
	
	public void testeCarregar() {
		
		System.out.println("");
		System.out.println("*** TESTE CARREGAR ***");
		System.out.println("");
		
		Pais esperado = new Pais(1,"Brasil",209003000,8511000.00);
		Pais novo = new Pais(1, null, 0, 0);
		novo.carregar();
		
	
		System.out.println("Esperado:      " + esperado);
		System.out.println("Pais Carregado: " + novo);
		System.out.println("");
		System.out.println("******************");
		
		assertEquals("Teste de carregar", esperado, novo);
			

		
	}
	
	@Test
	
	public void testeUpdate() {
		
		System.out.println("");
		System.out.println("*** TESTE ATUALIZAR ***");
		System.out.println("");
		
		paises.setId(3);       // MUDA ID DO OBJETO PAIS PARA 3
		copia.setId(3);			//COPIA MUDA SEU ID PARA 3 TBM
		paises.setArea(455);	//MUDA AREA DO OBJETO PAIS PARA 455
		copia.setArea(455);		//COPIA MUDA SUA AREA PARA 455 TBM
		paises.atualizar();    //CHAMA METODO ATUALIZAR 
		paises.carregar();		//CHAMA METODO CARREGAR 
		
		System.out.println("Esperado:      " + paises);
		System.out.println("Pais Carregado: " + copia);
		System.out.println("");
		System.out.println("******************");
		
		assertEquals("Teste de carregar", copia, paises);
		
		
		
		
	}
	
	@Test 
	
	public void testeExcluir() {
		
		System.out.println("");
		System.out.println("*** TESTE EXCLUIR ***");
		System.out.println("");
		
		
		copia.setId(0);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0.0);
		paises.excluir();
		paises.carregar();
		
		System.out.println("Esperado:      " + paises);
		System.out.println("Pais Carregado: " + copia);
		System.out.println("");
		System.out.println("******************");
		
		assertEquals("Teste Excluir", copia, paises);
		
		
	}
	
	@Test
	public void test04menorArea() {
		System.out.println("\nMenor Area");

		paises.menorArea();
		area = paises.getArea();
		nome = paises.getNome();
		copia.setArea(area);
		copia.setNome(nome);
		
	
		System.out.println(paises);
		System.out.println(copia);
	
		assertEquals("Menor área", copia, paises);
	}
	
	@Test
	public void test04maiorPopulacao() {
		System.out.println("\nMaiorPopulação");
		paises.maiorPopulacao();
		populacao = paises.getPopulacao();
		nome = paises.getNome();
		copia.setPopulacao(populacao);
		copia.setNome(nome);
		System.out.println("--------------------------------------------");
		System.out.println(paises);
		System.out.println(copia);
		System.out.println("--------------------------------------------");
		assertEquals("Maior populacção", copia, paises);
	}
	
	@Test
	public void test05testarVetor() {
		System.out.println("*** TRÊS PAISES ***");
		
		Pais[] vetor = Pais.tresPaises();
		for (Pais paises : vetor) {
			id = paises.getId();
			area = paises.getArea();
			nome = paises.getNome();
			populacao = paises.getPopulacao();
			copia.setId(id);
			copia.setArea(area);
			copia.setNome(nome);
			copia.setPopulacao(populacao);
			
			System.out.println(paises);
			System.out.println(copia);
			
			assertEquals("Agrupa 3 paises", copia, paises);
		}
	}
	
	
	
	

}
