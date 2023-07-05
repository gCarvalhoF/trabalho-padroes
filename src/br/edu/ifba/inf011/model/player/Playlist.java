package br.edu.ifba.inf011.model.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Playlist implements Playable {
	
	private String nome;
	private List<Playable> playables;
	
	public Playlist(String nome) {
		this.nome = nome;
		this.playables = new ArrayList<Playable>();
	}
	
	public void insert(Playable playable) {
		this.playables.add(playable);
	}	
	
	public String getNome() {
		return this.nome;
	};
	
	public String randomize() {
		return null;
	};

	public String execute() {
		StringBuilder str = new StringBuilder();
		str.append("--- Tocando playlist: ").append(this.nome).append(" ---").append("\n");
		str.append(playables.stream()
				.map(Playable::execute)
				.collect(Collectors.joining("\n")));

		return str.toString();
	}
}
