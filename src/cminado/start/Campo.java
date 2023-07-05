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

	boolean adicionarVizinho(Campo vizinho){
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaColuna = Math.abs(coluna-vizinho.coluna);
		int deltaLinha = Math.abs(linha-vizinho.linha);
		int deltaGeral = deltaColuna+deltaLinha;

		if(deltaGeral == 1 && !diagonal){
			vizinhos.add(vizinho);
			return true;
		} 
		else if (deltaGeral == 2 &&  diagonal) {
			vizinhos.add(vizinho);
			return true;
		} 
		else {
			return false;
		}
	}
}
