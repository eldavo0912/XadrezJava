package xadrez.pecas;

import tabuleiro.Tabuleiro;
import xadrez.PecasXadrez;
import xadrez.Cor;

public class Torre extends PecasXadrez{

    public Torre(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro,cor);


    }
    @Override
    public String toString(){
        return "T";
    }
}