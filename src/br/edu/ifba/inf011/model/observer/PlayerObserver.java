package br.edu.ifba.inf011.model.observer;

import br.edu.ifba.inf011.model.iterator.Player;

/* Observer: Observer pattern */
public interface PlayerObserver {
    void update(Player player);
}