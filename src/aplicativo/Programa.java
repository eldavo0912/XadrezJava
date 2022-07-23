	package aplicativo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ExecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecasXadrez;
import xadrez.XadrezPosicao;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		PartidaXadrez partida = new PartidaXadrez();
		
		List<PecasXadrez> capturadas = new ArrayList<>();
		
		while(true) {
			try{
				UI.clearScreen();
				UI.imprimirPartida(partida,capturadas);
				System.out.println(); 
				System.out.print("Origem: ");
				XadrezPosicao origem =UI.lerPosicao(scan);
				
				boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
				UI.clearScreen();
				UI.printBoard(partida.getPecas(),movimentosPossiveis);
				
				System.out.println();
				System.out.print("Destino: ");
				XadrezPosicao destino=  UI.lerPosicao(scan);
				PecasXadrez pecaCapturada = partida.execMovimento(origem,destino);
			
				if(pecaCapturada != null) {
					capturadas.add(pecaCapturada);
				}
			
			}catch(ExecaoXadrez e){
				System.out.println(e.getMessage());
				scan.nextLine();
				
			}catch(InputMismatchException e){
				System.out.println(e.getMessage());
				scan.nextLine();
				
			}
		}
	
	}
	
}
