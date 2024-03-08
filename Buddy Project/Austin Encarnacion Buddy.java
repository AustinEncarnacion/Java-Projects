/*
Austin Encarnacion
Math 130-03
Instructor: Mimi Rasky
11/18/2022
Lab#10 Class
*/
package buddy;
import java.util.*;
public class Buddy 
{
	public String name;
	private String telephone;
	public int age;
	
	private static int numMade;
	private static ArrayList<Buddy> list = new ArrayList<>();
	
	//default
	public Buddy()
	{
		this.name = "Carmen San Diego";
		this.telephone = "";
		this.age = 0;
		Buddy pal = new Buddy(name, telephone, age);
		list.add(pal);
	}
	
	//half-custom 
	public Buddy(String name, String telephone)
	{
		this.name = name;
		this.telephone = setPhone(telephone);
		Buddy pal = new Buddy(name, telephone, age);
		list.add(pal);
		Buddy.numMade++;
	}
	
	//full-custom
	public Buddy(String name, String telephone, int age)
	{
		this.name = name;
		this.telephone = setPhone(telephone);
		this.age = age;
//		Buddy pal = new Buddy(name, telephone, age);
//		list.add(pal);
		Buddy.numMade++;
	}
	
	public void setName(String name)
	{
		this.name = name;
		Buddy.numMade++;
	}
	
	public String setPhone(String s)
	{
		boolean valid = true;
		for (int i = 0; i < s.length(); i++)
		{
			if(i <= 2 || i >= 4)
				if (!Character.isDigit(s.charAt(i)))
					valid = false;
			if(i == 3)
				if(s.charAt(i) != '-')
					valid = false;
		}
		
		if(valid)
		{
			this.telephone = s;
			return s;
		}
		else
			return "";
	}
	
	public String getPhone()
	{
		return this.telephone;
	}
	
	public String toString()
	{
		return String.format("%-6s %-20s %-7s %-13s %-5s %d","Name: ", name, "Phone: ", telephone, "Age: ", age);
	}
	
	public static int getNumMade()
	{
		return numMade;
	}
	
	public static void showBuddys()
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).name);
		}
	}
	
	public boolean equals(Buddy a)
	{
		if (a == null)
			return false;
		if (this.getClass() != a.getClass())
			return false;
		if (this.name != a.name)
			return false;
		if (this.telephone != a.telephone)
			return false;
		if (this.age != a.age)
			return false;
		return true;
	}
	
	public void speak()
	{
		Random rand = new Random();
		int num;
		num = rand.nextInt(5) + 1;
		
		if(num == 5)
			System.out.println("Hey there!");
		else if (num == 4)
			System.out.println("How is your day going?");
		else if (num == 3)
			System.out.println("I like your outfit today!");
		else if (num == 2)
			System.out.println("I LOVE BABY EAGLES!");
		else if (num == 1)
			System.out.println(".....");
	}
}