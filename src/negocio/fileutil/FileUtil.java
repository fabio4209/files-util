package negocio.fileutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;

public class FileUtil {

	private static final String NOME_COMPLETO_ARQUIVO = ".\\arqTeste.txt";

	public static void main(String[] args) throws IOException{
		criarArquivoSeNaoExiste(NOME_COMPLETO_ARQUIVO);
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
