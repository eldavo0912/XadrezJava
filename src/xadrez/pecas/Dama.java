package xadrez.pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecasXadrez;

public class Dama extends PecasXadrez {

	public Dama(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao p = new Posicao(0, 0);
		// cima
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// baixo
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		Posicao pBispo = new Posicao(0, 0);

		// NOROESTE
		pBispo.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(pBispo) && !getTabuleiro().haPeca(pBispo)) {
			mat[pBispo.getLinha()][pBispo.getColuna()] = true;
			pBispo.setLinha(pBispo.getLinha() - 1);
			pBispo.setColuna(pBispo.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(pBispo) && haPecaOponente(p)) {
			mat[pBispo.getLinha()][pBispo.getColuna()] = true;
		}

		// NORDESTE
		pBispo.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(pBispo) && !getTabuleiro().haPeca(pBispo)) {
			mat[pBispo.getLinha()][pBispo.getColuna()] = true;
			pBispo.setLinha(pBispo.getLinha() - 1);
			pBispo.setColuna(pBispo.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(pBispo) && haPecaOponente(pBispo)) {
			mat[pBispo.getLinha()][pBispo.getColuna()] = true;
		}
		// SUDESTE
		pBispo.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(pBispo) && !getTabuleiro().haPeca(pBispo)) {
			mat[pBispo.getLinha()][pBispo.getColuna()] = true;
			pBispo.setLinha(pBispo.getLinha() + 1);
			pBispo.setColuna(pBispo.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(pBispo) && haPecaOponente(pBispo)) {
			mat[pBispo.getLinha()][pBispo.getColuna()] = true;
		}
		// SUDOESTE
		pBispo.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(pBispo) && !getTabuleiro().haPeca(pBispo)) {
			mat[pBispo.getLinha()][pBispo.getColuna()] = true;
			pBispo.setLinha(pBispo.getLinha() + 1);
			pBispo.setColuna(pBispo.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(pBispo) && haPecaOponente(pBispo)) {
			mat[pBispo.getLinha()][pBispo.getColuna()] = true;
		}

		return mat;
	}

	@Override
	public String toString() {
		return "D";
	}

	

}

