/*
Austin Encarnacion
Math 130-03
Instructor: Mimi Rasky
11/18/2022
Lab#10 Main
*/
package buddy;
import java.util.*;
public class BuddyTest 
{
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String name, number;
		int age;
		
		System.out.print("Please enter your buddy's first and last name:");
		name = scan.nextLine();
		System.out.print("Please enter your buddy's phone number in the following format (xxx-xxxx): ");
		number = scan.nextLine();
		Buddy b1 = new Buddy(name, number);
		
		System.out.print("Please enter another buddy's first and last name:");
		name = scan.nextLine();
		System.out.print("Please enter your buddy's phone number in the same format(xxx-xxxx): ");
		number = scan.nextLine();
		System.out.print("Please enter their age: ");
		age = scan.nextInt();
		Buddy b2 = new Buddy(name, number, age);
		
		Buddy[] buddy = new Buddy [rand.nextInt(15) + 5];
		
		for(int i = 0; i < buddy.length; i++)
			buddy[i] = new Buddy();
		buddy[1] = b2;
		
		for(int i = 0; i < buddy.length; i++)
			System.out.println(buddy[i]);
		
		System.out.println("buddy[3].equals(buddy[4]): " + buddy[3].equals(buddy[4]));
		buddy[3].setName("Austin");
		buddy[0].setPhone("12345678");
		System.out.println(buddy[0].getPhone());
		buddy[0].setPhone("098-0989");
		System.out.println(buddy[0].getPhone());
		
		for (int i = 0; i < buddy.length; i++)
		{
			if(buddy[i].age == 0)
				buddy[i].age = rand.nextInt(30) + 5;
		}
		
		System.out.println("buddy.getNumMade(): " + Buddy.getNumMade());
		
		System.out.println("buddy[1].equals(buddy[4]): " + buddy[1].equals(buddy[4]));
		
		for (int i = 0; i < buddy.length; i++)
		{
			System.out.printf("buddy[%d].speak(): ", i);
			buddy[i].speak();
		}
		
		Buddy.showBuddys();
	}
}
