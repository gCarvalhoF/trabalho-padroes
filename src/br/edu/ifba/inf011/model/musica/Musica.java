package br.edu.ifba.inf011.model.musica;

import br.edu.ifba.inf011.model.player.Playable;

public interface Musica extends Playable {
	public String getNome();
	public void reset();
	public Boolean finish();
	public String play();
}
