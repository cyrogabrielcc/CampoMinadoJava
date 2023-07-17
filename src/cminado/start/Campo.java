package cminado.start;

import java.util.ArrayList;
import java.util.List;

import cminado.exceptions.ExplosaoException;

public class Campo {
	public final int linha;
	

	public final int coluna;


	private boolean minado;

	private boolean aberto=false;
	//private boolean fechado=false;
	private boolean marcado=false;

	// Criando a lista dos campos vizinhos
	private List<Campo> vizinhos = new ArrayList<>();

	// Retornando a linha
	public int getLinha() {
		return linha;
	}

	//retornando a coluna
	public int getColuna() {
		return coluna;
	}
	
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
	void AlternarMarcacao(){
		if(!aberto){
			marcado = !marcado;
		}
	}

	boolean abrir(){
		if (!aberto && !marcado ) {
			aberto = true;

			if (minado) {
				throw new ExplosaoException();
			}
			if(vizinhancaSegura()){
				vizinhos.forEach(v->v.abrir());
			}
			return true;
		} 
		else {
			return false;
		}
	}

	boolean vizinhancaSegura(){
		return vizinhos.stream().noneMatch(v->v.minado);
	}

	public boolean isMarcado(){
		return marcado;
	}

	public void minar(){
		minado=true;
	}
	public boolean isAberto(){
		return aberto;
	}

	public boolean isFechado(){
		return !isAberto();
	}

	boolean objetivoAlcancado(){
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;

		return  desvendado || protegido;
	}

	long minasNaVizinhanca(){
		return vizinhos.stream().filter(v->v.minado).count();
	}

	void reiniciar(){
		aberto = false;
		minado=false;
		marcado=false;
	}

	public String toString(){
		if (marcado) {
			return "x";
		} 
		else if (aberto && minado){
			return "*";
		} 
		else if (aberto && minasNaVizinhanca()>0){
			return Long.toString(minasNaVizinhanca());
		}
		else if (aberto){
			return " ";
		}
		else {
			return "?";
		}
	}



}
