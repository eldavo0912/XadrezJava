package xadrez.pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecasXadrez;

public class Peao extends PecasXadrez {

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		// TODO Auto-]zgenerated constructor stub
	}
	@Override 
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);
		
		if (getCor() == Cor.BRANCO) {
			p.setValues(posicao.getLinha() - 1, posicao.getColuna());
			if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() -1 , posicao.getColuna());
			if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p2) && getContadorMovimento()==0) {
				mat[p.getLinha()][p.getColuna()]=true;
			}
			p.setValues(posicao.getLinha() - 1, posicao.getColuna()-1);
			if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() - 1, posicao.getColuna()+1);
			if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
		}else {
			p.setValues(posicao.getLinha() + 1, posicao.getColuna());
			if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() +1 , posicao.getColuna());
			if(getTabuleiro().posicaoExiste(p2) && !getTabuleiro().haPeca(p2) && getContadorMovimento()==0) {
				mat[p.getLinha()][p.getColuna()]=true;
			}
			p.setValues(posicao.getLinha() + 1, posicao.getColuna()-1);
			if (getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() + 1, posicao.getColuna()+1);
			if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}		
		}
		return mat;
	}
}

