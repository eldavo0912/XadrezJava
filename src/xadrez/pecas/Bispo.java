package xadrez.pecas;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecasXadrez;

public class Bispo  extends PecasXadrez{

	
	
	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao p = new Posicao(0,0);
		
		
		//NOROESTE 
		p.setValues(posicao.getLinha() -1, posicao.getColuna()-1);
    	while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
    		mat[p.getLinha()][p.getColuna()]= true;
    		p.setValues(p.getLinha()-1, p.getColuna()-1);
    	}
    	if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
    		mat[p.getLinha()][p.getColuna()]= true;
    	}
    	
    	//NORDESTE 
    	p.setValues(posicao.getLinha() -1, posicao.getColuna()+1);
   	   	while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
   	   		mat[p.getLinha()][p.getColuna()]= true;
   	   		p.setValues(p.getLinha()-1, p.getColuna()+1);
       	}
   	   	if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
   	   		mat[p.getLinha()][p.getColuna()]= true;
   	    }
   	   	//SUDESTE
    	p.setValues(posicao.getLinha() +1, posicao.getColuna()+1);
   	   	while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
   	   		mat[p.getLinha()][p.getColuna()]= true;
   	   		p.setLinha(p.getLinha() +1);
   	   		p.setColuna(p.getColuna()+1);
       	}
   	   	if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
   	   		mat[p.getLinha()][p.getColuna()]= true;
   	    }
   	   	//SUDOESTE
    	p.setValues(posicao.getLinha() +1, posicao.getColuna()-1);
   	   	while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
   	   		mat[p.getLinha()][p.getColuna()]= true;
   	   		p.setLinha(p.getLinha() +1);
   	   		p.setColuna(p.getColuna()-1);
       	}
   	   	if(getTabuleiro().posicaoExiste(p) && haPecaOponente(p)) {
   	   		mat[p.getLinha()][p.getColuna()]= true;
   	    }
		
		
		
		return mat;
	}

	
	
	
}
