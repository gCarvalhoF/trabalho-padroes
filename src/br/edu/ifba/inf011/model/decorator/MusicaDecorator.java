package br.edu.ifba.inf011.model.decorator;

/* Decorator: Decorator pattern */
public abstract class MusicaDecorator implements Musica {
    protected Musica musicaDecorada;
    public String nome;

    public MusicaDecorator(Musica musicaDecorada) {
        this.musicaDecorada = musicaDecorada;
    }

    @Override
    public String getNome() {
        return this.musicaDecorada.getNome();
    }

    @Override
    public String execute() {
        return this.musicaDecorada.execute();
    }

    @Override
    public void reset() {
        this.musicaDecorada.reset();
    }

    @Override
    public Boolean finish() {
        return this.musicaDecorada.finish();
    }

    @Override
    public String play() {
        return musicaDecorada.play();
    }

}
