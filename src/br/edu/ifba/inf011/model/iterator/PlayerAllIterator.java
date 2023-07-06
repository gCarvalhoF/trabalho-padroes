package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.Playable;

import java.util.List;

/* Concrete Iterator: Iterator pattern */
public class PlayerAllIterator implements PlayerIterator {
    private final List<Playable> items;
    private Integer index;

    public PlayerAllIterator(List<Playable> items) {
        this.items = items;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.items.size();
    }

    @Override
    public Playable proximo() {
        if(this.temProximo()) return items.get(index++);
        return null;
    }

    public void reset() {
        this.index = 0;
    }
}