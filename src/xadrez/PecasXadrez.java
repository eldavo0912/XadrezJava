package xadrez;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public abstract class PecasXadrez extends Peca{
	private Cor cor;
	private int contadorMovimento;
	public PecasXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	

	public int getContadorMovimento() {
		return contadorMovimento;
	}
	public void somarContadorMovimento() {
		contadorMovimento++;
	}
	public void tirarContadorMovimento() {
		contadorMovimento--;
	}
	
	
	
	protected boolean haPecaOponente(Posicao posicao) {
		PecasXadrez p = (PecasXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() !=  cor;
	}
	
	
	
	public XadrezPosicao pegarPosicaoXadrez() {
		return XadrezPosicao.daPosicao(posicao);
	}
	
	
}