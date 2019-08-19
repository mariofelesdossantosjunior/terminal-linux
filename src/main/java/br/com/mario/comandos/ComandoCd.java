package br.com.mario.comandos;

import br.com.mario.MeuTokenizer;
import br.com.mario.Terminal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComandoCd extends Comando {

    public ComandoCd(String nome, Terminal terminal) {
        super(nome, terminal);
    }

    @Override
    public void executar(MeuTokenizer auxiliares) {
        StringBuilder pathDigitado = new StringBuilder();

        while (auxiliares.hasMoreTokens()) {
            pathDigitado.append(auxiliares.nextToken());
        }

        String diretorioFinal = getTerminal().getDiretorioAtual()
                .concat("/".concat(pathDigitado.toString()))
                .replaceAll("//", "/");

        Path path = Paths.get(diretorioFinal);

        if (Files.isDirectory(path)) {
            String destino = diretorioFinal.replaceAll("//", "/");

            try {
                destino = new File(destino).getCanonicalPath();
                getTerminal().setDiretorioAtual(destino);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Diretorio invalido!");
        }
    }

}
