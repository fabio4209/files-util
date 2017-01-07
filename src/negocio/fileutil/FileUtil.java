package negocio.fileutil;

import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileUtil {

	private static final String 
		NOME_COMPLETO_ARQUIVO = ".\\arqTextoGerado.txt";

	public static void main(String[] args) throws IOException{
		
		if (ArquivoNaoExiste(NOME_COMPLETO_ARQUIVO)){
			criarArquivo(NOME_COMPLETO_ARQUIVO);
		}
		else {
			//escreverNoArquivo(NOME_COMPLETO_ARQUIVO);
			escreverEmArquivoGrande(NOME_COMPLETO_ARQUIVO);
		}
		
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
	
	
	/**
	 * @descripion Escreve em arquivos maiores, é mais performatico
	 */	
	public static void escreverEmArquivoGrande(String nomeArquivo) {
		Path arquivo = Paths.get(nomeArquivo);

		Charset charset = Charset.forName("US-ASCII");
		String texto = "to be or not to be II";
		BufferedWriter writer = null;
		
		try {
			writer = Files.newBufferedWriter(arquivo,charset,
					StandardOpenOption.APPEND);
			writer.write(texto, 0, texto.length());
			if (writer != null) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @descripion Escreve em arquivos menores, pois
	 * utiliza um array de bytes
	 */	
	public static void escreverNoArquivo(String nomeArquivo){
		Path arquivo = Paths.get(nomeArquivo);
		String texto = "to be or not to be";
		try {
			Files.write(arquivo, texto.getBytes());
		}
		catch (Exception e){
			e.printStackTrace();
		}
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
