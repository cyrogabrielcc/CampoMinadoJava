package cminado.start;

public class Campo {
	public final int linha;
	public final int coluna;
	private boolean minado;

	public Campo(int linha, int coluna) {
		this.coluna=coluna;
		this.linha=linha;
	}
}
