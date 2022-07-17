package xadrez;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		iniciarPartida();
	}
	public PecasXadrez[][] getPecas(){
		PecasXadrez[][] matriz =  new PecasXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];		
		for(int i =0 ; i<tabuleiro.getLinhas();i++) {
			for(int j = 0; j< tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecasXadrez) tabuleiro.peca(i,j);
			}
		}
		return matriz;
	
	}
	private void iniciarPartida(){
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(0,4));
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(0,0));

		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(0,7));

	}
}
