/*
Austin Encarnacion
Math 130-03
Instructor: Mimi Rasky
10/7/2022
Lab #5
*/

package labs;
import java.util.*;
public class DiceGame 
{
	public static void main(String[]args)
	{
		Random rand = new Random();
		Scanner keyboard = new Scanner(System.in);
		String placebo;
		int diceComputer, diceUser, loadedDice, loadedDice2, loadedComputer, loadedUser, compDiff, userDiff, userPoints = 0, compPoints = 0, tieGames = 0;
		
		for (int i = 1; i <= 15; i++)
		{
			//Loaded dice roll for computer
			loadedDice = rand.nextInt(100) + 1;
			if (loadedDice < 57)
				loadedComputer = 9;
			else if (loadedDice < 64)
				loadedComputer = 8;
			else if (loadedDice < 70)
				loadedComputer = 7;
			else if (loadedDice < 75)
				loadedComputer = 6;
			else if (loadedDice < 80)
				loadedComputer = 5;
			else if (loadedDice < 85)
				loadedComputer = 4;
			else if (loadedDice < 90)
				loadedComputer = 3;
			else if (loadedDice < 95)
				loadedComputer = 2;
			else
				loadedComputer = 1;
			
			//Loaded dice roll for User
			loadedDice2 = rand.nextInt(100) + 1;
			if (loadedDice2 < 57)
				loadedUser = 9;
			else if (loadedDice2 < 64)
				loadedUser = 8;
			else if (loadedDice2 < 70)
				loadedUser = 7;
			else if (loadedDice2 < 75)
				loadedUser = 6;
			else if (loadedDice2 < 80)
				loadedUser = 5;
			else if (loadedDice2 < 85)
				loadedUser = 4;
			else if (loadedDice2 < 90)
				loadedUser = 3;
			else if (loadedDice2 < 95)
				loadedUser = 2;
			else
				loadedUser = 1;
			
			//Random dice roll for user and computer
			diceUser = rand.nextInt(9) + 1;
			userDiff = Math.abs(diceUser - loadedUser); //Calculated difference between loaded dice and random dice for user
			diceComputer = rand.nextInt(9) + 1;
			compDiff = Math.abs(diceComputer - loadedComputer); //Calculated difference between loaded dice and random dice for computer
		
			//Format for results for computer
			System.out.println("Computer Turn Round #" + i);
			System.out.println("- - - - - - - - - - - - - - - -");
			System.out.println("Normal Die: " + diceComputer);
			System.out.println("Loaded Die: " + loadedComputer);
			System.out.println("Difference: " + compDiff);
			System.out.println();
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
			//If-else for user-interaction to roll their turn
			if (i < 15)
			{
				System.out.print("TEST YOUR LUCK AND PRESS 'ENTER' TO ROLL YOUR DICE!!\n- - - - - - - - - - - - - - - - - - - - - - - - - - -");
				placebo = keyboard.nextLine();
			}
			else
			{
				System.out.print("LAST CHANCE TO GET A GOOD ROLL! (press enter)\n- - - - - - - - - - - - - - - - - - - - - - - - - - -");
				placebo = keyboard.nextLine();
			}
			//User roll results
			System.out.println();
			System.out.println("User Turn Round #" + i);
			System.out.println("- - - - - - - - - - - - - - - -");
			System.out.println("Normal Die: " + diceUser);
			System.out.println("Loaded Die: " + loadedUser);
			System.out.println("Difference: " + userDiff);
			System.out.println();
			
			//Determination of who wins the round
			if (userDiff > compDiff)
			{
				System.out.println("The User wins this round!!!!!!!");
				userPoints++;
			}
			else if (compDiff > userDiff)
			{
				System.out.println("The Computer wins this round!!!!!");
				compPoints++;
			}
			else
			{
				System.out.println("Oh no, this round is a TIE!!");	
				tieGames++;
			}
			System.out.println();
			
			//User interaction to continue onto the next round
			if (i != 15) 
			{	
			System.out.printf("- - - - Press ENTER to continue to Round #%d - - - -", i + 1);
			placebo = keyboard.nextLine();
			System.out.println();
			}
		}
		
		//Final results to see who won the game overall
		System.out.println();
		System.out.println("Total Number of Computer Wins: " + compPoints + "\n");
		System.out.println("    Total Number of User Wins: " + userPoints + "\n");
		System.out.println("    Total Number of tie games: " + tieGames + "\n");
		if (userPoints > compPoints)
			System.out.println("The User is the GRAND CHAMPION!");
		else if (compPoints > userPoints)
			System.out.println("The Computer is the GRAND CHAMPION!");
		else 
			System.out.println("TIE GAME!!! Nobody wins this game, sorry...");
	}
}