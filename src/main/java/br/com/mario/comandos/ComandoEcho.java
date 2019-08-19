package br.com.mario.comandos;

import br.com.mario.MeuTokenizer;
import br.com.mario.Terminal;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Formatter;

public class ComandoEcho extends Comando {

    public ComandoEcho(String nome, Terminal terminal) {
        super(nome, terminal);
    }

    @Override
    public void executar(MeuTokenizer auxiliares) {
        String textoOriginal = auxiliares.getTextoOriginal();


        //Cria o arquivo com a mensagem do usuario
        if (textoOriginal.contains(">") && textoOriginal.contains(".txt")) {
            String[] valores = auxiliares.getTextoOriginalMenosPrimeiroToken().split(">");

            String mensagem = valores[0];
            String nomeArquivo = valores[1].replaceAll("\"", "");

            try {
                Formatter saida = new Formatter(
                        getTerminal().getDiretorioAtual()
                                .concat("/")
                                .concat(nomeArquivo));

                saida.format(mensagem);
                saida.close();

            } catch (FileNotFoundException e) {
                System.out.println("Erro ao criar arquivo!");
            }
        } else {
            System.out.println(auxiliares.getTextoOriginalMenosPrimeiroToken());
        }
    }

}
