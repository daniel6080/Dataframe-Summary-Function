import java.util.*;

public class DiceGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Player1 = 10, Player2 = 10;
		int CurrentPlayer = 1;
		int first_try = 1;
	
		Scanner scanner = new Scanner(System.in);
	
		while (Player1 > 1 && Player2 > 1) {
			System.out.println("PLAYER 1: " + Player1 + "  PLAYER 2: " + Player2);
			System.out.println("CURRENT PLAYER: " + CurrentPlayer);
			System.out.print("(r)oll, (s)kip, Command: ");
			String command = scanner.next();
			System.out.println();
			
		if (command.equals("r")){
			int dice = (int)(Math.random() * 6) + 1;
			first_try = 0;
			if (CurrentPlayer == 1) {
				Player2 = Player2 - dice;
				System.out.println("dice: " + dice + ", Player 2's score = " + Player2);
			}
			else if (CurrentPlayer == 2) {
				Player1 = Player1 - dice;
				System.out.println("dice: " + dice + ", Player 1's score = " + Player1);
			}
		}
		else if (command.equals("s")){
			if (first_try == 0) {
				if (CurrentPlayer == 1) {
					CurrentPlayer = 2;
					first_try = 1;
				}
				else if (CurrentPlayer ==2) {
					CurrentPlayer = 1;
					first_try = 1;
				}
			}
			else if (first_try == 1)
				System.out.println("Skip is not allowed on the first try after the turn change.");
		}
		else
			System.out.println("Illegal command");
		}
		
		if(Player1 == 0 || Player1 == 1)
			System.out.println("Player 2 win");
		else if(Player2 == 0 || Player2 == 1)
			System.out.println("Player 1 win");
		else if(Player1 < 0)
			System.out.println("Player 1 win");
		else if(Player2 < 0)
			System.out.println("Player 2 win");
	}
}
