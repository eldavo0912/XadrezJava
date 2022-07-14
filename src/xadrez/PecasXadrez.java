package xadrez;

import Tabuleiro.Peca;
import Tabuleiro.Tabuleiro;

public class PecasXadrez extends Peca{
	private Cor cor;

	public PecasXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	
	
}
