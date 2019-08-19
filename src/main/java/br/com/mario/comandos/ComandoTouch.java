package br.com.mario.comandos;

import br.com.mario.MeuTokenizer;
import br.com.mario.Terminal;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class ComandoTouch extends Comando {

    public ComandoTouch(String nome, Terminal terminal) {
        super(nome, terminal);
    }

    @Override
    public void executar(MeuTokenizer auxiliares) {
        String nomeArquivo = auxiliares.nextToken();

        try {
            Formatter saida = new Formatter(
                    getTerminal().getDiretorioAtual()
                            .concat("/")
                            .concat(nomeArquivo));

            saida.close();
        } catch (FileNotFoundException e) {
            System.out.println("Diretorio invalído, ou sem permissão de acesso!");
        }
    }
}
