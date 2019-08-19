package br.com.mario.comandos;

import br.com.mario.MeuTokenizer;
import br.com.mario.Terminal;

public class ComandoExit extends Comando {

    public ComandoExit(String nome, Terminal terminal) {
        super(nome, terminal);
    }

    @Override
    public void executar(MeuTokenizer auxiliares) {
        System.out.println("Buy");
        System.exit(0);
    }
}
