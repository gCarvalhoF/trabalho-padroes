package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.Playable;
import br.edu.ifba.inf011.model.composite.Playlist;

import java.util.List;
import java.util.Random;

/* Concrete Iterator: Iterator pattern */
public class RandomModeIterator implements PlayerIterator {

    private final Random random;
    private final List<Playable> items;

    public RandomModeIterator(List<Playable> items) {
        this.items = items;
        this.random = new Random();
    }

    @Override
    public boolean temProximo() {
        return true;
    }

    @Override
    public Playable proximo() {
        Playable playlistItem = items.get(nextRandom());
        if (playlistItem instanceof Playlist) {
            return ((Playlist) playlistItem).randomize();
        }
        return playlistItem;
    }
    private int nextRandom() {
        return random.nextInt(this.items.size());
    }
}