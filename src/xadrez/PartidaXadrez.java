package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Dama;
import xadrez.pecas.Peao;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;
 

public class PartidaXadrez {

	private Cor jogadorAtual;
	private int rodada;
	private boolean check;
	private boolean checkMate;
	
	private Tabuleiro tabuleiro;
	
	private List<Peca> pecasCapturadas = new ArrayList<>();
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		rodada =1;
		jogadorAtual = Cor.BRANCO;
		
		
		iniciarPartida();
		
		
	}
	public int getRodada() {
		return rodada;
	}
	public Cor getJogadorAtual	() {
		return jogadorAtual;
	}
	public boolean getCheck() {
		return check;
	}
	public boolean getCheckMate() {
		return checkMate;
	}

	
	
	
	public PecasXadrez[][] getPecas(){
		PecasXadrez[][] matriz =  new PecasXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];		
		for(int i =0 ; i<tabuleiro.getLinhas();i++) {
			for(int j = 0; j< tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecasXadrez) tabuleiro.peca(i,j);
			}
		}
		return matriz;
	
	}
	
	public boolean[][] movimentosPossiveis(XadrezPosicao posicaoOrigem){
		Posicao posicao =posicaoOrigem.paraPosicao();
		validarPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();

	}
	
	
	public PecasXadrez execMovimento(XadrezPosicao posicaoOrigem,XadrezPosicao posicaoDestino) {
			Posicao origem = posicaoOrigem.paraPosicao();
			Posicao destino = posicaoDestino.paraPosicao();
			validarPosicaoOrigem(origem);
			validarPosicaodestino(origem,destino);
			Peca pecaCapturada = fazerMovimento(origem,destino);
			
			if(testarCheck(jogadorAtual)) {
				desfazerMovimento(origem, destino, pecaCapturada);
				throw new ExecaoXadrez("Você não pode se por em xeque");
			}
			
			check = (testarCheck(oponente(jogadorAtual))) ? true : false;
			
			if(testeChequeMate(oponente(jogadorAtual))) {
				checkMate = true;
			}else {
				proximaRodada();
				
			}
			
			return (PecasXadrez)pecaCapturada;
			
	}
	private void validarPosicaodestino(Posicao origem, Posicao destino) {
		// TODO Auto-generated me
		
		if(!tabuleiro.peca(origem).movimentoPossiveil(destino)) {
			throw new ExecaoXadrez("A PECA ESCOLHIDA NÃO PODE SER MOVIDA PARA A POSICAO DE DESTINO");
		}
		
	}

	private void desfazerMovimento(Posicao origem,Posicao destino,Peca pecaCapturada) {
		PecasXadrez p = (PecasXadrez)tabuleiro.removerPeca(destino);
		p.tirarContadorMovimento();
		tabuleiro.colocarPeca(p, origem);
		
		if(pecaCapturada != null) {
			tabuleiro.colocarPeca( pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada); 
		}
		
	}
	
	private Peca fazerMovimento(Posicao origem, Posicao destino) {
		PecasXadrez p =  (PecasXadrez)tabuleiro.removerPeca(origem);
		p.somarContadorMovimento();
		Peca pecaCapturada =tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(p, destino);
		
		if(pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		return pecaCapturada;
	}
	private void validarPosicaoOrigem(Posicao origem) {
		if (!tabuleiro.haPeca(origem)) {
			throw new ExecaoXadrez("NÃO HÁ PEÇAS NA POSIÇÃO DE ORIGEM");
		}
		if (jogadorAtual != ((PecasXadrez)tabuleiro.peca(origem)).getCor()) {
			throw new ExecaoXadrez("A PEÇA ESCOLHIDA NÃO É SUA");
		}
		if(!tabuleiro.peca(origem).haUmMovimentoPossivel()) {
			throw new ExecaoXadrez("NÃO MOVIMENTO POSSIVEL PARA A PEÇA");
		}
	}

	public void proximaRodada() {
		rodada++;
		jogadorAtual =  (jogadorAtual==Cor.BRANCO)? Cor.PRETO: Cor.BRANCO;
	}
	
	private Cor oponente(Cor cor) {
		return (cor == Cor.BRANCO)?Cor.PRETO : Cor.BRANCO;
		
	}
	
	private PecasXadrez rei(Cor cor) {
		List<Peca> lista = pecasNoTabuleiro.stream().filter(x-> ((PecasXadrez)x).getCor() == cor).collect(Collectors.toList());
	
		for(Peca p : lista) {
			if (p instanceof Rei) {
				return (PecasXadrez)p;
			}
		}
		throw new IllegalStateException("Não existe rei da cor "+cor+" no jogo");
		
	}
	
	private boolean testarCheck(Cor cor) {
		 Posicao posicaoRei= rei(cor).pegarPosicaoXadrez().paraPosicao(); 
		 List<Peca> pecasOponentes = pecasNoTabuleiro.stream().filter(x-> ((PecasXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
		 for(Peca p : pecasOponentes) {
			 boolean[][] mat = p.movimentosPossiveis();
			 if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				 return true;
			 }	 
		 }
		 
		 return false;
	}
	private boolean testeChequeMate(Cor cor) {
		if (!testarCheck(cor)) {
			return false;
		}
		List<Peca> lista = pecasNoTabuleiro.stream().filter(x-> ((PecasXadrez)x).getCor() ==cor).collect(Collectors.toList()); 
	
		for(Peca p : lista){
			 boolean[][] mat = p.movimentosPossiveis();
			 for(int i =0;i<tabuleiro.getLinhas();i++) {
				  for(int j=0;j<tabuleiro.getColunas();j++) {
					  if(mat[i][j]) {
						  Posicao origem =((PecasXadrez) p).pegarPosicaoXadrez().paraPosicao();
						  Posicao destino = new Posicao(i,j);
						  Peca pecaCapturada =fazerMovimento(origem, destino);
						  boolean testarXeque = testarCheck(cor);
						  desfazerMovimento(origem, destino, pecaCapturada);
						  if(!testarXeque) {
							  return false;
						  }
					  }
				  }
			 }
		}
			
		return true;
		
	}
 	
	private void colocarNovaPeca(char coluna, int linha, PecasXadrez peca) {
		tabuleiro.colocarPeca(peca, new XadrezPosicao(coluna, linha).paraPosicao());
		pecasNoTabuleiro.add(peca);
	}
	
	private void iniciarPartida(){
		colocarNovaPeca('a',2,new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('b',2,new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('c',2,new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d',2,new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e',2,new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('f',2,new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('g',2,new Peao(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('h',2,new Peao(tabuleiro, Cor.BRANCO));
		
		colocarNovaPeca('c',1,new Bispo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('f',1,new Bispo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('g',1,new Cavalo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('b',1,new Cavalo(tabuleiro, Cor.BRANCO));
		
		colocarNovaPeca('a',1,new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('h',1,new Torre(tabuleiro, Cor.BRANCO));
		
		colocarNovaPeca('d',1,new Dama(tabuleiro, Cor.BRANCO));
		
		
		colocarNovaPeca('e',1,new Rei(tabuleiro, Cor.BRANCO));
		
		
		
		
		colocarNovaPeca('a',7,new Peao(tabuleiro, Cor.PRETO));
		colocarNovaPeca('b',7,new Peao(tabuleiro, Cor.PRETO));
		colocarNovaPeca('c',7,new Peao(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d',7,new Peao(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e',7,new Peao(tabuleiro, Cor.PRETO));
		colocarNovaPeca('f',7,new Peao(tabuleiro, Cor.PRETO));
		colocarNovaPeca('g',7,new Peao(tabuleiro, Cor.PRETO));
		colocarNovaPeca('h',7,new Peao(tabuleiro, Cor.PRETO));
		
		colocarNovaPeca('c',8,new Bispo(tabuleiro, Cor.PRETO));
		colocarNovaPeca('f',8,new Bispo(tabuleiro, Cor.PRETO));
		colocarNovaPeca('b',8,new Cavalo(tabuleiro, Cor.PRETO));
		colocarNovaPeca('g',8,new Cavalo(tabuleiro, Cor.PRETO));
		
		colocarNovaPeca('a',8,new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('h',8,new Torre(tabuleiro, Cor.PRETO));
		
		colocarNovaPeca('d',8,new Dama(tabuleiro, Cor.PRETO));
		

		colocarNovaPeca('e',8,new Rei(tabuleiro, Cor.PRETO));
		
	}
}
