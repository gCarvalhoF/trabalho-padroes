package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.Playable;

import java.util.List;

/* Concrete Iterator: Iterator pattern */
public class RepeatAllIterator implements PlayerIterator {

    private final List<Playable> playables;
    private Integer index;

    public RepeatAllIterator(List<Playable> playables) {
        this.playables = playables;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return true;
    }

    @Override
    public Playable proximo() {
        if (index >= playables.size()) this.reset();
        return playables.get(index++);
    }

    public void reset() {
        this.index = 0;
    }
}