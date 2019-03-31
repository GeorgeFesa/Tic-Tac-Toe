package ex8;

import java.util.Scanner;

public class TicTacToe {
	
	public static void checkWinner(Player player1, Player player2) {
		
		if(!(player1.getTurn())) {
			System.out.print("\n" + player1.getName() + " wins!");
			
		}
		else if(!(player2.getTurn())) {
			System.out.print("\n" + player2.getName() + " wins!");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		String[][] array = new String[4][4];
		Scanner in = new Scanner(System.in);
		String XorO2;
		
		
		
		for(int i = 1; i<=3; ++i) {
			for(int j = 1; j<=3; ++j) {
				array[i][j] = " ";
			}
		}
		
		
		// Player1
		System.out.print("Enter name for Player1: ");
		String name1 = in.nextLine();
		System.out.print("Choose X or O: ");
		String XorO1 = in.nextLine();
		Player player1 = new Player(name1, XorO1);
		
		
		// Player2
		System.out.print("Enter name for Player2: ");
		String name2 = in.nextLine();
		if(player1.getXorO().equals("X")) {XorO2 = "O";}
		else {XorO2 = "X";}
		Player player2 = new Player(name2, XorO2);
		
		
		// Plays first
		System.out.println("\nWho plays first, " + player1.getName()
		                  + " or " + player2.getName() + "?");
		String answer = in.nextLine();
		if(player1.getName().equals(answer)) {
			player1.setTurn(true);
			player2.setTurn(false);
		}
		else {
			player1.setTurn(false);
			player2.setTurn(true);
		}
		
		
		
		// Game loop
		boolean flag = true;
		int n = 0;
		while(flag){
			
			n++;	// Players turns in total
			
			for(int i = 1; i<=3; ++i) {
				System.out.println("-------");
				for(int j = 1; j<=3; ++j) {
					System.out.print("|" + array[i][j]);
				}
				System.out.println("|");
			}
			System.out.println("-------");
			
			
			
			int posR;
			int posC;
			do {
				
				System.out.print("\nPlease select a row: ");
				posR  = in.nextInt();
				
				System.out.print("Please select a column: ");
				posC = in.nextInt();
				
				if(!(array[posR][posC].equals(" "))) {
					System.out.print("\nThe previous player has played there,"
							          + " try again!\n");
				}
				
			}while(!(array[posR][posC].equals(" ")));
			
			
			
			// Checks player's turn
			if(player1.getTurn()) {
				array[posR][posC] = player1.getXorO();
				player1.setTurn(false);
				player2.setTurn(true);
			}
			else {
				array[posR][posC] = player2.getXorO();
				player2.setTurn(false);
				player1.setTurn(true);
			}
			
			
			
			if(n>=5) {
				// Checks if a player did tic-tac-toe
				for(int i = 1; i<=3; ++i) {
					
					for(int j = 1; j<=1; ++j) {
									
						if((array[i][j].equals(array[i][j+1]))
								&& array[i][j].equals(array[i][j+2])) {
							
							checkWinner(player1, player2);
							flag = false;
							
						}
					}	
				}
				
				for(int j = 1; j<=3; ++j) {
					for(int i = 1; i<=1; ++i) {
						
						if((array[i][j].equals(array[i+1][j]))
								&& array[i][j].equals(array[i+2][j])) {
							
							checkWinner(player1, player2);
							flag = false;
						}
						
					}
				}
				
				if(array[1][1].equals(array[2][2]) 
						&& array[1][1].equals(array[3][3])) {
					
					checkWinner(player1, player2);
					flag = false;
				}
				
				if(array[1][3].equals(array[2][2]) 
						&& array[1][3].equals(array[3][1])) {
					
					checkWinner(player1, player2);
					flag = false;
				}
				
				if(n==9) {
					System.out.print("\nDraw!");
					flag = false;
				}
			}
			
			
		}
		
		in.close();

	}

}
