package br.edu.ifba.inf011.model.musica;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

import java.io.IOException;
import java.util.List;

public class MusicaTraducaoPt extends MusicaDecorator {

    private List<String> letra;
    private String nome;
    private Integer linha;

    public MusicaTraducaoPt(Musica musicaDecorada) throws IOException {
        super(musicaDecorada);
        this.nome = musicaDecorada.getNome();
        this.letra = ResourceLoader.instance().loadTraducaoPt(nome);
        this.reset();
    }

    public String getNome() {
        return this.nome;
    }

    public void reset() {
        this.linha = 0;
    }

    public Boolean finish() {
        return this.linha >= this.letra.size();
    }

    public String play() {
        if (!musicaDecorada.finish())
            return musicaDecorada.play() + "\n" + this.letra.get(this.linha++);
        return this.letra.get(this.linha++);
    }

    public String execute() {
        this.reset();
        StringBuffer str = new StringBuffer();
        while(!this.finish()){
            str.append(this.play() + "\n");
        }
        return str.toString();
    }
}
