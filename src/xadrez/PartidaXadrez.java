package xadrez;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;
 

public class PartidaXadrez {

	private Cor jogadorAtual;
	private int rodada;
	
	
	private Tabuleiro tabuleiro;
	
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
			proximaRodada();
			return (PecasXadrez)pecaCapturada;
	}
	private void validarPosicaodestino(Posicao origem, Posicao destino) {
		// TODO Auto-generated me
		
		if(!tabuleiro.peca(origem).movimentoPossiveil(destino)) {
			throw new ExecaoXadrez("A PECA ESCOLHIDA NÃO PODE SER MOVIDA PARA A POSICAO DE DESTINO");
		}
		
	}


	private Peca fazerMovimento(Posicao origem, Posicao destino) {
		Peca p =  tabuleiro.removerPeca(origem);
		Peca pecaCapturada =tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(p, destino);
		
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
	
	
	private void colocarNovaPeca(char coluna, int linha, PecasXadrez peca) {
		tabuleiro.colocarPeca(peca, new XadrezPosicao(coluna, linha).paraPosicao());
	}
	
	private void iniciarPartida(){
		colocarNovaPeca('e',1,new Rei(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('a',1,new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('h',1,new Torre(tabuleiro, Cor.BRANCO));
		
		
		colocarNovaPeca('e',8,new Rei(tabuleiro, Cor.PRETO));
		colocarNovaPeca('a',8,new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('h',8,new Torre(tabuleiro, Cor.PRETO));
		
	}
}
