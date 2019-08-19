package br.com.mario.comandos;

import br.com.mario.MeuTokenizer;
import br.com.mario.Terminal;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ComandoLs extends Comando {

    public ComandoLs(String nome, Terminal terminal) {
        super(nome, terminal);
    }

    @Override
    public void executar(MeuTokenizer auxiliares) {
        String filePath = auxiliares.nextToken();

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(Locale.getDefault())
                .withZone(ZoneId.systemDefault());

        Path path = Paths.get(filePath);

        if (Files.isDirectory(path)) {
            DirectoryStream<Path> directoryStream;
            try {
                directoryStream = Files.newDirectoryStream(path);
                directoryStream.forEach(directory -> {
                    try {
                        System.out.printf("%-8s   bytes   %10s   Dir:%5s   %30s  %n",
                                Files.size(directory),
                                formatter.format(Files.getLastModifiedTime(directory).toInstant()),
                                Files.isDirectory(directory),
                                directory.getFileName());
                    } catch (IOException e) {
                        System.out.println("Erro ao localizar diretório!");
                    }
                });
            } catch (IOException e) {
                System.out.println("Erro ao localizar diretório!");
            }
        } else {
            System.out.println("Diretório não encontrado.");
        }
    }
}
