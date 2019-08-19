package br.com.mario.comandos;

import br.com.mario.MeuTokenizer;
import br.com.mario.Terminal;

public abstract class Comando {
    private String nome;
    private Terminal terminal;

    public Comando(String nome, Terminal terminal) {
        this.nome = nome;
        this.terminal = terminal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public abstract void executar(MeuTokenizer auxiliares);

    @Override
    public String toString() {
        return "Comando{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
