package xadrez.pecas;

import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecasXadrez;

public class Rei extends PecasXadrez{
    
	
	private PartidaXadrez partida;
	
	public Rei (Tabuleiro tabuleiro,Cor cor,PartidaXadrez partida){
        super(tabuleiro,cor);
        this.partida = partida;

    }
    @Override
	public String toString() {
		return "R";
	}
    public boolean podeMover(Posicao posicao) {
    	PecasXadrez p = (PecasXadrez)getTabuleiro().peca(posicao);
    	return p == null || p.getCor() != getCor();
    	
    }
    
    private boolean testeTorreRoque(Posicao posicao) {
    	
    	PecasXadrez p =(PecasXadrez)getTabuleiro().peca(posicao);
    	
    	
    	
    	return p != null && p instanceof Torre && p.getCor() == getCor() && p.getContadorMovimento() == 0 ;
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
    	
    	//ROQUE 
    	if(getContadorMovimento() ==0 && !partida.getCheck()) {
    		//ala do rei
    	
    		Posicao posicaoTorre1 = new Posicao(posicao.getLinha(), posicao.getColuna() +3);
    		if(testeTorreRoque(posicaoTorre1)) {
    			Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() +1 ) ;
    			Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() +2 ) ;
        		if(getTabuleiro().peca(p1) == null  && getTabuleiro().peca(p2) == null ) {
        			mat[posicao.getLinha()][posicao.getColuna()+2] = true;
        		}
    		}
    		//Ala da dama
    		Posicao posicaoTorre2 = new Posicao(posicao.getLinha(),posicao.getColuna()-4);
    		if (testeTorreRoque(posicaoTorre2)) {
    			Posicao p1 =new Posicao(posicao.getLinha(), posicao.getColuna() -1 ) ;
    			Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() -2 ) ;
    			Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() -3 ) ;
    			
    			if(getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null&& getTabuleiro().peca(p3) ==null) {
    				mat[posicao.getLinha()][posicao.getColuna()-2]=true;
    			}
    		}
    		
    		
    	}
 
     	
    	
    	return mat;
    
    }
    
}