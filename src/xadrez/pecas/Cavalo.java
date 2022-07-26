package xadrez.pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecasXadrez;

public class Cavalo extends PecasXadrez{

	@Override
	public String toString() {
		return "C";
	}

	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		// TODO Auto-generated constructor stub
	}
	private boolean podeMover(Posicao posicao) {
		PecasXadrez p = (PecasXadrez)getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao p = new Posicao(0,0);
		
		//cima e esquerda
    	p.setValues(posicao.getLinha()-2,posicao.getColuna()-1);
    	
    	if (getTabuleiro().posicaoExiste(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    		
    	
    	//cima e direita
    	p.setValues(posicao.getLinha()-2,posicao.getColuna()+1);
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
    	//esqueda cima
    	p.setValues(posicao.getLinha()-1,posicao.getColuna()-2);
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
   
    	//esqueda baixo
    	p.setValues(posicao.getLinha()+1,posicao.getColuna()-2);
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
    	
       	//direita cima
    	p.setValues(posicao.getLinha()-1,posicao.getColuna()+2);
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
       	//direita baixo
    	p.setValues(posicao.getLinha()+1,posicao.getColuna()+2);
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
    	
    	
       	//baixo direita
    	p.setValues(posicao.getLinha()+2,posicao.getColuna()+1);
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
 
       	//baixo esquerda
    	p.setValues(posicao.getLinha()+2,posicao.getColuna()-1);
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
  
 
    	
    	
    	return mat;
 	} 
	
	
}
