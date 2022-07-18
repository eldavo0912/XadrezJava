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
	private void colocarNovaPeca(char coluna, int linha, PecasXadrez peca) {
		tabuleiro.colocarPeca(peca, new XadrezPosicao(coluna, linha).paraPosicao());
	}
	
	private void iniciarPartida(){
		colocarNovaPeca('e',1,new Rei(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('a',8,new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('h',8,new Torre(tabuleiro, Cor.PRETO));

	}
}
