package xadrez.pecas;

import Tabuleiro.Posicao;
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
    public boolean podeMover(Posicao posicao) {
    	PecasXadrez p = (PecasXadrez)getTabuleiro().peca(posicao);
    	return p == null || p.getCor() != getCor();
    	
    }
    
    
    
    
    
    @Override
    public boolean[][] movimentosPossiveis(){
    	boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
    	Posicao p = new Posicao(0,0);
    	
    	//cima
    	p.setValues(posicao.getLinha()-1,posicao.getColuna());
    	
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    		
    	
    	//baixo
    	p.setValues(posicao.getLinha()+1,posicao.getColuna());
    	
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
    	//left
    	p.setValues(posicao.getLinha(),posicao.getColuna()-1);
    	
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
    	
    	//tight
    	p.setValues(posicao.getLinha(),posicao.getColuna()+1);
    	
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
    	
       	//noroeste
    	p.setValues(posicao.getLinha()-1,posicao.getColuna()-1);
    	
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
       	//nordeste
    	p.setValues(posicao.getLinha()-1,posicao.getColuna()+1);
    	
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
    	
    	
    	
       	//sudoeste
    	p.setValues(posicao.getLinha()+1,posicao.getColuna()-1);
    	
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
 
       	//sudeste
    	p.setValues(posicao.getLinha()+1,posicao.getColuna()+1);
    	
    	if (getTabuleiro().posicaoExiste(p) && podeMover(p) ) {
    			mat[p.getLinha()][p.getColuna()] = true;
    	}
  
 
    	
    	
    	return mat;
    
    }
    
}