package br.com.mario;

import br.com.mario.comandos.Comando;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Terminal terminal = new Terminal("mario");
    private static Scanner leitor = new Scanner(System.in);
    private static MeuTokenizer tokenizer;

    public static void main(String[] args) {

        Comando comando;

        do {
            saida(terminal.getUsuario().getNome()
                    .concat(":")
                    .concat(terminal.getDiretorioAtual()
                            .concat("$ ")));

            String textoDigitado = leitor.nextLine();

            //Recupera todos os comandos digitados pelo usuario
            tokenizer = new MeuTokenizer(textoDigitado, " ");

            String primeiroComando = tokenizer.nextToken();

            if (primeiroComando != null
                    && !primeiroComando.isEmpty()
                    && terminal.validaComando(primeiroComando)) {

                comando = terminal.recuperaComando(primeiroComando);

                if (comando != null) {

                    MeuTokenizer auxiliares =
                            (tokenizer.hasMoreTokens())
                            ? tokenizer //Retorna todos comandos digitados
                            : new MeuTokenizer(terminal.getDiretorioAtual(), " "); //Retorna o diretorio atual

                        comando.executar(auxiliares);
                }
            } else {
                System.out.println("Comando invalido. Tente novamente!");
            }
        } while (true);

    }

    public static void saida(String texto) {
        try {
            Thread.sleep(500);
            System.out.print(texto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
