package br.com.mario;

import br.com.mario.comandos.*;

import java.util.LinkedList;

public class Terminal {

    private Usuario usuario;
    private LinkedList<Comando> variaveisAmbiente;
    private String diretorioAtual;

    public Terminal(String nome) {
        this.usuario = new Usuario(nome);
        this.variaveisAmbiente = new LinkedList<>();
        this.diretorioAtual = "/";
        iniciaVariaveisAmbiente();
    }

    private LinkedList<Comando> iniciaVariaveisAmbiente() {
        variaveisAmbiente.add(new ComandoCd("cd", this));
        variaveisAmbiente.add(new ComandoLs("ls", this));
        variaveisAmbiente.add(new ComandoTouch("touch", this));
        variaveisAmbiente.add(new ComandoEcho("echo", this));
        variaveisAmbiente.add(new ComandoCat("cat", this));
        variaveisAmbiente.add(new ComandoExit("exit", this));
        return variaveisAmbiente;
    }

    public boolean validaComando(String comandoDigitado) {
        return getVariaveisAmbiente()
                .stream()
                .anyMatch(comando -> comando.getNome().equals(comandoDigitado));
    }

    public Comando recuperaComando(String comandoDigitado) {
        return getVariaveisAmbiente()
                .stream()
                .filter(comando -> comando.getNome().equals(comandoDigitado))
                .findFirst()
                .orElse(null);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDiretorioAtual() {
        return diretorioAtual;
    }

    public void setDiretorioAtual(String diretorioAtual) {
        this.diretorioAtual = diretorioAtual;
    }

    public LinkedList<Comando> getVariaveisAmbiente() {
        return variaveisAmbiente;
    }

    public void setVariaveisAmbiente(LinkedList<Comando> variaveisAmbiente) {
        this.variaveisAmbiente = variaveisAmbiente;
    }
}
