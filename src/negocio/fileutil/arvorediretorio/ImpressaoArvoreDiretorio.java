package negocio.fileutil.arvorediretorio;

import static java.nio.file.FileVisitResult.*;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

//walking the folder tree (https://goo.gl/4yNB9o)

public class ImpressaoArvoreDiretorio extends SimpleFileVisitor<Path> {

	public BasicFileAttributes lerAtributosBasicosArquivo(Path file)
			throws IOException {
		return Files.readAttributes(file, BasicFileAttributes.class);
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		if (attrs.isRegularFile()) {
			System.out.println(file);
		} else {
			System.out.format("Não sou arquivo: %s", file);
		}

		return CONTINUE;
	}

}
