package xadrez.pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecasXadrez;

public class Peao extends PecasXadrez {
	
	private PartidaXadrez partida; 
	
	public Peao(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida) {
		super(tabuleiro, cor);
		this.partida = partida;
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
			// ENPASSANT
			if(posicao.getLinha() ==3 ) {
				Posicao esquerda = new Posicao(posicao.getLinha() 	, posicao.getColuna()-1);
				if(getTabuleiro().posicaoExiste(esquerda)&& haPecaOponente(p) && getTabuleiro().peca(esquerda) == partida.getEnpassanteVuneravel()) {
					mat[esquerda.getLinha()-1][esquerda.getColuna()]= true;
				}
				Posicao direita = new Posicao(posicao.getLinha() , posicao.getColuna()+1);
				if(getTabuleiro().posicaoExiste(direita)&& haPecaOponente(direita) && getTabuleiro().peca(direita) == partida.getEnpassanteVuneravel()) {
					mat[direita.getLinha()-1][direita.getColuna()]= true;
				}
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
				mat[p.getLinha()][p.getColuna()] = 	true;
			}		
			if(posicao.getLinha() == 4 ) {
				Posicao esquerda = new Posicao(posicao.getLinha() 	, posicao.getColuna()-1);
				if(getTabuleiro().posicaoExiste(esquerda)&& haPecaOponente(p) && getTabuleiro().peca(esquerda) == partida.getEnpassanteVuneravel()) {
					mat[esquerda.getLinha()+1][esquerda.getColuna()]= true;
				}
				Posicao direita = new Posicao(posicao.getLinha() , posicao.getColuna()+1);
				if(getTabuleiro().posicaoExiste(direita)&& haPecaOponente(direita) && getTabuleiro().peca(direita) == partida.getEnpassanteVuneravel()) {
					mat[direita.getLinha()+1][direita.getColuna()]= true;
				}
			}
		}
		return mat;
	}
}

