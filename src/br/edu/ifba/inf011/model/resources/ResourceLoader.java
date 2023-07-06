package br.edu.ifba.inf011.model.resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.edu.ifba.inf011.model.decorator.*;

public class ResourceLoader {
	
	public static String DIR_NAME = System.getProperty("user.dir") + "\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";

	public static ResourceLoader loader;
	
	public static ResourceLoader instance() {
		String os = System.getProperty("os.name");

		if (Objects.equals(os, "Mac OS X"))
			ResourceLoader.DIR_NAME = System.getProperty("user.dir") + "/src/br/edu/ifba/inf011/model/resources/data/";

		if(ResourceLoader.loader == null)
			ResourceLoader.loader = new ResourceLoader();
		return ResourceLoader.loader;
	}
	
	public Musica createMusicaComLetraCifra(String nome) throws IOException {
		return new MusicaLetra(new MusicaNotas(new MusicaTitulo(nome)));
	}
	public Musica createMusicaComLetraTraducaoPt(String nome, String language) throws IOException {
		return new MusicaLetra(new MusicaTraducao(new MusicaTitulo(nome), language));
	}

	public Musica createMusicaComLetraCifraTraducaoPt(String nome, String language) throws IOException {
		return new MusicaTraducao(new MusicaLetra(new MusicaNotas(new MusicaTitulo(nome))), language);
	}

	public Musica createMusicaComCifra(String nome) throws IOException {
		return new MusicaNotas(new MusicaTitulo(nome));
	}
	
	public List<String> loadNotas(String nome) throws IOException {
		return this.loadResource(nome, "notas");
	}
	
	public List<String> loadLetra(String nome) throws IOException {
		return this.loadResource(nome, "letra");
	}

	public List<String> loadTraducaoPt(String nome, String language) throws IOException {
		return this.loadResource(nome, language);
	}

	public List<String> loadResource(String nome, String extensao) throws IOException {
		List<String> resource = new ArrayList<String>();
        Path path = Paths.get(ResourceLoader.DIR_NAME + nome + "." + extensao);
        Files.lines(path, StandardCharsets.ISO_8859_1).forEach(resource::add);
        return resource;
	}

}
