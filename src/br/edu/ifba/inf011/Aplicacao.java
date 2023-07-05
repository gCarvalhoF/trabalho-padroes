package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.musica.*;
import br.edu.ifba.inf011.model.player.Player;
import br.edu.ifba.inf011.model.player.Playlist;
import br.edu.ifba.inf011.model.player.PlayerObserver;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao {

	private void musica() throws IOException {

		ResourceLoader.DIR_NAME = "/Users/gabrielfraga/coding/college_stuff/trabalho-padroes/src/br/edu/ifba/inf011/model/resources/data/";

		Musica musica =  new MusicaTraducaoPt(new MusicaLetra(new MusicaNotas(new MusicaTitulo("Lullaby"))));
		Musica musica2 =  new MusicaTraducaoPt(new MusicaLetra(new MusicaNotas(new MusicaTitulo("GodSaveTheQueen"))));
		Musica musica3 =  new MusicaTraducaoPt(new MusicaLetra(new MusicaNotas(new MusicaTitulo("ReelAroundFountain"))));


		Playlist playlist = new Playlist("Teste");
		Playlist playlist2 = new Playlist("Tchurusbengo");

		playlist2.insert(musica2);

		Player player = new Player();

		// Adicionando um observador ao Player
		PlayerObserver observer = new PlayerObserver() {
			@Override
			public void update(Player player) {
				// Implementar o que acontece quando o Player é atualizado
				System.out.println("Player updated");
			}
		};
		player.addObserver(observer);

		player.insert(playlist2);
		player.insert(musica3);

		// Execute as músicas e as playlists no Player
		while(player.temProximo()) {
			System.out.println(player.proximo().execute());
		}
	}

	public static void main(String[] args) throws IOException{
		Aplicacao app = new Aplicacao();
		app.musica();
	}
}
