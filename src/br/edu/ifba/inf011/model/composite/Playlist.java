package br.edu.ifba.inf011.model.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/* Composite: Composite pattern */
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
	
	public Playable randomize() {
		int random = new Random().nextInt(playables.size());
		Playable playable = playables.get(random);
		if (playable instanceof Playlist) {
			return ((Playlist) playable).randomize();
		}
		return playable;
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
