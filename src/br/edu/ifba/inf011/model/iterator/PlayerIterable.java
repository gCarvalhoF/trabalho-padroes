package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.Playable;

/* Aggregate: Iterator pattern */
public interface PlayerIterable {
    void insert(Playable item);
    PlayerIterator createIterator();
}
