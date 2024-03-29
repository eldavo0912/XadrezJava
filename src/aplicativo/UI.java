package aplicativo;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecasXadrez;
import xadrez.XadrezPosicao;

public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		}
	
	public static XadrezPosicao lerPosicao(Scanner scan) {

		try {
			String c = scan.nextLine();
			char coluna = c.charAt(0);
			int linha = Integer.parseInt(c.substring(1));
			return new XadrezPosicao(coluna, linha);
		} 
		catch (RuntimeException e) {
			throw new InputMismatchException("Erro ao ler a posição, digite  uma posição valida");
		}
	}
	
	public static void imprimirPartida(PartidaXadrez partida, List<PecasXadrez> capturads ) {	
		
		printBoard(partida.getPecas());
		System.out.println();
		imprimirPecaCapturada(capturads);
		System.out.println();
		System.out.println("Turno: "+ partida.getRodada());
		if(!partida.getCheckMate()) {
			System.out.println("AGUARDANDO JOGADOR: "+partida.getJogadorAtual());
			if(partida.getCheck()) {
				System.out.println("XEQUE!!");
			}
		}else {
			System.out.println("XEQUE-MATE!!!!");
			System.out.println("Vencedor: "+partida.getJogadorAtual());
		}
		
	}
	
	

	public static void printBoard(PecasXadrez[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				printPeca(pecas[i][j],false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");

	}
	
	

	public static void printBoard(PecasXadrez[][] pecas, boolean[][] movimentosPossiveis) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				printPeca(pecas[i][j], movimentosPossiveis[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");

	}
	
	private static void imprimirPecaCapturada(List<PecasXadrez>  capturada	) {
			List<PecasXadrez> brancas = capturada.stream().filter(x-> x.getCor() == Cor.BRANCO).collect(Collectors.toList());
			List<PecasXadrez> pretas = capturada.stream().filter(x-> x.getCor() == Cor.PRETO).collect(Collectors.toList());
	
			System.out.println("Pecas Capturadas: ");
			System.out.print("BRANCAS: ");
			System.out.print(ANSI_WHITE);
			System.out.print(Arrays.toString(brancas.toArray()));
			System.out.println(ANSI_RESET);
			System.out.print("PRETAS: ");
			System.out.print(ANSI_YELLOW);
			System.out.print(Arrays.toString(pretas.toArray()));
			System.out.print(ANSI_RESET);
			
	}
	

	private static void printPeca(PecasXadrez peca, boolean fundo) {
		if (fundo) {
			System.out.print(ANSI_GREEN_BACKGROUND);
		}
		if (peca == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_WHITE + peca + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
}
