package br.edu.ifba.inf011.model.decorator;

import br.edu.ifba.inf011.model.composite.Playable;

/* Component: Decorator pattern */
public interface Musica extends Playable {
	public String getNome();
	public void reset();
	public Boolean finish();
	public String play();
}
