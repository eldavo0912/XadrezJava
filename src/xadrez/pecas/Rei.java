package xadrez.pecas;

import Tabuleiro.Tabuleiro;
import xadrez.PecasXadrez;
import xadrez.Cor;

public class Rei extends PecasXadrez{
    public Rei (Tabuleiro tabuleiro,Cor cor){
        super(tabuleiro,cor);

    }
    @Override
	public String toString() {
		return "R";
	}
    
}