package br.edu.ifba.inf011.model.decorator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Concrete Decorator: Decorator pattern */
/* Leaf: Composite pattern */
public class MusicaTitulo implements Musica {

    private List<String> linhas;
    private String nome;
    private Integer linha;

    public MusicaTitulo(String nome) throws IOException {
        this.nome = nome;
        this.reset();
        this.linhas = new ArrayList<String>(Arrays.asList("***Tocando Música: " + nome + "***"));
    }

    public String getNome() {
        return this.nome;
    }

    public void reset() {
        this.linha = 0;
    }

    public Boolean finish() {
        return this.linha >= this.linhas.size();
    }

    public String play() {
        return this.linhas.get(this.linha++);
    }

    public String execute() {
        this.reset();
        StringBuffer str = new StringBuffer();
        str.append(this.getNome() + "\n");
        this.linha++;

        return str.toString();
    }
}
