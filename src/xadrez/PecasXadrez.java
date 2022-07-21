package xadrez;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public abstract class PecasXadrez extends Peca{
	private Cor cor;

	public PecasXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	protected boolean haPecaOponente(Posicao posicao) {
		PecasXadrez p = (PecasXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() !=  cor;
	}
	
	
}