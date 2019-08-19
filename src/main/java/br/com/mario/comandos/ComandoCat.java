package br.com.mario.comandos;

import br.com.mario.MeuTokenizer;
import br.com.mario.Terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ComandoCat extends Comando {

    private static Scanner scanner;

    public ComandoCat(String nome, Terminal terminal) {
        super(nome, terminal);
    }

    @Override
    public void executar(MeuTokenizer auxiliares) {
        String nomeArquivo = auxiliares.nextToken();
        String pathFile = getTerminal().getDiretorioAtual()
                .concat("/")
                .concat(nomeArquivo);

        abrirArquivo(pathFile);
    }

    private void abrirArquivo(String pathFile) {
        Path path = Paths.get(pathFile);
        if (Files.exists(path)) {
            try {
                scanner = new Scanner(path);
                lerRegistros();
                fecharArquivo();
            } catch (IOException e) {
                System.out.println("Erro ao abrir arquivo!");
            }
        } else {
            System.out.println("Arquivo não encontrado!");
        }
    }

    private void lerRegistros() {
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

    private void fecharArquivo() {
        if (scanner != null) {
            scanner.close();
        }
    }
}