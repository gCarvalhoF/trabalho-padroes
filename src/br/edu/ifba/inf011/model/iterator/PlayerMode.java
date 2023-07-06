package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.Playable;

import java.util.List;

public enum PlayerMode{

	PlayerAll {
		@Override
		public PlayerIterator createIterator(List<Playable> items) {
			return new PlayerAllIterator(items);
		}
	},
	RepeatAll {
		@Override
		public PlayerIterator createIterator(List<Playable> items) {
			return new RepeatAllIterator(items);
		}
	},
	RandomMode {
		@Override
		public PlayerIterator createIterator(List<Playable> items) {
			return new RandomModeIterator(items);
		}
	};

	public abstract PlayerIterator createIterator(List<Playable> items);
}

