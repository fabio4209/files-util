package negocio.fileutil.arvorediretorio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VisitarArvoreDiretorio {
	
	private static final String STRING_DIRETORIO_INICIAL = "c:\\GEARQ\\GAM";
	
	public void varrerDiretorioESubDiretorio() {
		Path diretorioInicial = Paths.get(STRING_DIRETORIO_INICIAL);
		ImpressaoArvoreDiretorio impressaoArvoreDiretorio = new ImpressaoArvoreDiretorio();

		try {
			Files.walkFileTree(diretorioInicial, impressaoArvoreDiretorio);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
