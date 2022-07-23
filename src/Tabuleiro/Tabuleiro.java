package Tabuleiro;

import xadrez.Cor;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {

		if (linhas < 1 || colunas < 1) {
			throw new ExecaoTabuleiro("Error ao Criar o Tabuleiro: é preciso ter no minimo 1 linha e 1 coluna");
		}
		

		
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];

	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {

		if (!posicaoExiste(linha, coluna)) {
			throw new ExecaoTabuleiro("Posição não existe no tabuleiro");
		}
		return pecas[linha][coluna];
	}

	
	
	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExecaoTabuleiro("Posição não existe no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];

	}

	public void colocarPeca(Peca peca, Posicao posicao) {
		if (haPeca(posicao)) {
			throw new ExecaoTabuleiro("há uma peça na posição" + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
		
		
	}

	private boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}

	public boolean haPeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExecaoTabuleiro("Posição não existe no tabuleiro");
		}
		return peca(posicao) != null;
	}

	public Peca removerPeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExecaoTabuleiro("posicao inesxistente");
		}
		if (peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
}
