package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.Playable;
import br.edu.ifba.inf011.model.observer.PlayerObserver;

import java.util.ArrayList;
import java.util.List;

/* Concrete Aggregate: Iterator pattern */
/* Subject: Observer pattern */
public class Player implements PlayerIterable {

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

	public void reset() {
		this.index = 0;
	}

	public String getMode(){
		return this.mode.toString();
	}

	public void setMode(PlayerMode mode) {
		this.mode = mode;
		notifyObservers();
	}

	@Override
	public PlayerIterator createIterator() {
		return this.mode.createIterator(playables);
	}
}
