package br.edu.ifba.inf011;

import java.io.IOException;
import java.util.Random;

import br.edu.ifba.inf011.model.decorator.*;
import br.edu.ifba.inf011.model.iterator.Player;
import br.edu.ifba.inf011.model.composite.Playlist;
import br.edu.ifba.inf011.model.iterator.PlayerMode;
import br.edu.ifba.inf011.model.iterator.PlayerIterator;
import br.edu.ifba.inf011.model.observer.PlayerObserver;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao implements PlayerObserver {

	private final Player player;

	public Aplicacao() {
		this.player = new Player();
		this.player.addObserver(this);
	}

	private void musica() throws IOException, InterruptedException {
		var resource = ResourceLoader.instance();

		Musica musica =  resource.createMusicaComLetraCifra("Lullaby");
		Musica musica2 =  resource.createMusicaComLetraCifraTraducaoPt("GodSaveTheQueen", "pt");
		Musica musica3 =  resource.createMusicaComLetraTraducaoPt("ReelAroundFountain", "pt");
		Musica musica4 =  resource.createMusicaComCifra("GodSaveTheQueen");


		Playlist playlist = new Playlist("Teste");
		Playlist playlistTest = new Playlist("Tchurusbengo");

		playlistTest.insert(musica2);
		playlistTest.insert(musica4);

		player.insert(playlistTest);
		player.insert(musica3);
		player.insert(musica);

		PlayerIterator iterator = player.createIterator();

		while(iterator.temProximo()) {
			System.out.println(iterator.proximo().execute());
			Thread.sleep(1000);

			int numero = new Random().nextInt(2,8);
			if (numero % 5 == 0){
				player.setMode(PlayerMode.RepeatAll);
				iterator = player.createIterator();
			}else if (numero % 7 == 0){
				player.setMode(PlayerMode.RandomMode);
				iterator = player.createIterator();
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Aplicacao app = new Aplicacao();
		app.musica();
	}

	@Override
	public void update(Player player) {
		System.out.printf("\n-----------\nTocando no modo: %s!-----------\n", player.getMode());
	}
}
