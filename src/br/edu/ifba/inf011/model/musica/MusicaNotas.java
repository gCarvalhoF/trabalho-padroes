package br.edu.ifba.inf011.model.musica;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class MusicaNotas extends MusicaDecorator {
	
	private List<String> notas;
	private String nome;
	private Integer linha;

	public MusicaNotas(Musica musicaDecorada) throws IOException {
		super(musicaDecorada);
		this.nome = musicaDecorada.getNome();
		this.notas = ResourceLoader.instance().loadNotas(nome);
		this.reset();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void reset() {
		 this.linha = 0;
	}
	
	public Boolean finish() {
		return this.linha >= this.notas.size();
	}
	
	public String play() {
		if (!musicaDecorada.finish())
			return musicaDecorada.play() + "\n" + this.notas.get(this.linha++);
		return this.notas.get(this.linha++);
	}

	public void setAcordes(List<String> notas) {
		this.notas = notas;
	}

	public String execute() {
		this.reset();
		StringBuffer str = new StringBuffer();
		while(!this.finish()) {
			str.append(this.play() + "\n");
		}
		return str.toString();
	}
}
