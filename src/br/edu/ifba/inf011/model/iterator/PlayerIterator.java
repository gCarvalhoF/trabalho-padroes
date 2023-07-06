package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.Playable;

/* Iterator: Iterator pattern */
public interface PlayerIterator {

    boolean temProximo();

    Playable proximo();
}
