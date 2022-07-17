package xadrez.pecas;

import Tabuleiro.Tabuleiro;
import xadrez.PecasXadrez;
import xadrez.Cor;

public class Torre extends PecasXadrez{

    public Torre(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro,cor);


    }
    @Override
	public String toString() {
		return "T";
	}
    
}