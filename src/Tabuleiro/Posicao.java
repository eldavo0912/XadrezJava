 package Tabuleiro;

import xadrez.XadrezPosicao;

public class Posicao{
	private int coluna;
	private int linha;
	
	
	
	
	public Posicao(int linha, int coluna) {
		super();
		this.coluna = coluna;
		this.linha = linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	@Override
	public String toString() {
		return "Posicao [linha=" + linha + ", coluna=" + coluna+ "]";
	}

	public void setValues(int linha,int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	
	
	
	
	
	
	
}
