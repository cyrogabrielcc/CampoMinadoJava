package cminado.start;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	public final int linha;
	public final int coluna;
	private boolean minado;

	private boolean aberto=false;
	private boolean fechado=false;
	private boolean marcado=false;

	private List<Campo> vizinhos = new ArrayList<>();

	public Campo(int linha, int coluna) {
		this.coluna=coluna;
		this.linha=linha;
	}

	boolean adicionarVizinho(Campo Vizinho){
		return false;
	}
}
