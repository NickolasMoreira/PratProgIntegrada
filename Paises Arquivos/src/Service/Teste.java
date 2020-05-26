package Service;



import java.io.File;
public class Teste {

	public static void main(String[] args) {
		
	
//File arquivo = new File("C:\\Users\\MOREIRA\\Desktop\\FACULDADE\\dsa\\Pais\\Paises Arquivos\\WebContent\\log", "LogUsers.txt");
		File arquivo = new File(".\\WebContent\\log");
		if(arquivo.isFile()){
			System.out.println("Arquivo");
			} else if(arquivo.isDirectory()){
			String[] arquivos = arquivo.list();
			System.out.println("Diretório");
			for(String a : arquivos) {
				System.out.println(a);
			}
			}
		
		
	

	}

}
