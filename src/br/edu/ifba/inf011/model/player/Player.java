package br.edu.ifba.inf011.model.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Classe Player implementa o padrão Iterator e Observer
public class Player implements PlayerIterator {

	private List<Playable> playables;
	private PlayerMode mode;
	private Integer index;
	private List<PlayerObserver> observers;

	public Player() {
		this.observers = new ArrayList<PlayerObserver>();
		this.setMode(PlayerMode.PlayerAll);
		this.reset();
		this.playables = new ArrayList<Playable>();
	}

	public void addObserver(PlayerObserver observer) {
		if(this.observers == null) {
			this.observers = new ArrayList<PlayerObserver>();
		}
		this.observers.add(observer);
	}

	public void removeObserver(PlayerObserver observer) {
		this.observers.remove(observer);
	}

	private void notifyObservers() {
		for (PlayerObserver observer : observers) {
			observer.update(this);
		}
	}

	public void insert(Playable playable) {
		this.playables.add(playable);
	}

	@Override
	public boolean temProximo() {
		if (Objects.requireNonNull(mode) == PlayerMode.RepeatAll) {
			return true;
		}
		return index < playables.size();
	}

	@Override
	public Playable proximo() {
		if (!temProximo()) {
			return null;
		}

		Playable playable = null;
		if (Objects.requireNonNull(mode) == PlayerMode.RepeatAll) {
			index = (index++) % playables.size();
			playable = playables.get(index);
		} else {
			playable = playables.get(index++);
		}

		return playable;
	}

	public void reset() {
		this.index = 0;
	}

	public void setMode(PlayerMode mode) {
		this.mode = mode;
		notifyObservers();
	}
}
