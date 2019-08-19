package br.com.mario;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class MeuTokenizer extends StringTokenizer {
    private String textoOriginal;
    private String delimit;

    public MeuTokenizer(String textoOriginal, String delim) {
        super(textoOriginal, delim);
        this.textoOriginal = textoOriginal;
        this.delimit = delim;
    }

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public LinkedList<String> getAllTokens() {
        LinkedList<String> comandos = new LinkedList<>();

        while (this.hasMoreTokens()) {
            comandos.add(this.nextToken());
        }
        return comandos;
    }

    public String getTextoOriginalMenosPrimeiroToken() {
        StringBuilder texto = new StringBuilder();

        while (this.hasMoreTokens()) {
            texto.append(this.nextToken().concat(" "));
        }

        return texto.toString().replaceAll("\"", "");
    }

    public String getDelimit() {
        return delimit;
    }

    public void setDelimit(String delimit) {
        this.delimit = delimit;
    }
}
