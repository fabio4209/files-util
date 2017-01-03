package negocio.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;

public class FileUtil {

	private static final String 
		NOME_COMPLETO_ARQUIVO = ".\\arqTextoGerado.txt";

	public static void main(String[] args) throws IOException{
		
		if (ArquivoNaoExiste(NOME_COMPLETO_ARQUIVO)){
			System.out.println("Arquivo ainda não existe");
			criarArquivo(NOME_COMPLETO_ARQUIVO);
		}
		
		//TODO: escreverNoArquivo(NOME_COMPLETO_ARQUIVO);
		//criarArquivoSeNaoExiste(NOME_COMPLETO_ARQUIVO);
	}
	
	//Path Operations: https://goo.gl/R8IcMu
	public static boolean ArquivoNaoExiste(String nomeArquivo){
		Path arquivo = Paths.get(nomeArquivo);
		if (Files.notExists(arquivo)){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//Descrição: Cria um arquivo vazio
	public static void criarArquivo(String nomeArquivo){
		Path arquivo = Paths.get(nomeArquivo);
		
		try {
			//Files é uma helper class
			Files.createFile(arquivo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void escreverNoArquivo(){
		Path arquivo = Paths.get(nomeCompletoArquivo);
		
	}
	
	/**
	 * @throws IOException
	 */
	public static void criarArquivoSeNaoExiste(String nomeCompletoArquivo) throws IOException {
		Path arquivo = Paths.get(nomeCompletoArquivo);

		//Path Operations: https://goo.gl/R8IcMu
		if (Files.notExists(arquivo)){

			System.out.println("Arquivo ainda não existe, será criado");

			Path arquivoCriado = Files.createFile(arquivo);

			FileWriter fWriter = new FileWriter(arquivoCriado.toFile());
			fWriter.write("C");
			fWriter.close();
		} else {
			System.out.println("Arquivo Já existe");
		}
	}
	
	
}
