/*
Austin Encarnacion
Math 130-03
Instructor: Mimi Rasky
11/25/2022
Project 5
*/
package payroll;
import java.io.*;
import java.util.*;
public class JavaProject5 
{
	public static void main(String []args) throws IOException
	{
		ArrayList<Payroll> employee = new ArrayList<>();
		getInput(employee);
		printOut(employee);
	}
	
	public static int getInput(ArrayList<Payroll> raList) throws IOException
	{
		//File read
		File file = new File("C:\\dataProject5Fall22.txt");

		if(!file.exists())
		{
			System.out.println("The file cannot be found.");
			System.exit(0);
		}
		Scanner inputFile = new Scanner(file);
		int ctr = 0;
		double rate, hrs;
		
		//while loop because the amount of employees processed can vary
		while(inputFile.hasNext())
		{
			rate = inputFile.nextDouble();
			hrs = inputFile.nextDouble();
			
			raList.add(new Payroll(rate, hrs));
			ctr++;
		}
		
		inputFile.close();
		return ctr;
	}
	
	public static void printOut(ArrayList<Payroll> list) throws IOException
	{
		double hrs = 0, gross = 0, net = 0, fedTax = 0, stateTax = 0, fica = 0, ueiDI = 0, employerCost = 0;
		PrintWriter outputFile = new PrintWriter("C:\\AustinEmployerDataPayRoll.txt");
		
		//header
		outputFile.printf("%10s %8s %10s %10s %11s %10s %11s %8s %10s\n", "Rate", "Hours", "Gross", "Fed", "State", "FICA", "UEI/DI", "Net", "Cost");
		
		for(int i = 0; i < list.size(); i++)
		{
			outputFile.printf("%10.2f %8.1f", list.get(i).rate, list.get(i).hrs);
			
			//print to file. If-else to appropriately display if the employee worked overtime or not.
			if(list.get(i).overtimeFlag)
				outputFile.printf("%12.2f%s %8.2f %10.2f %10.2f %10.2f %10.2f %10.2f\n", list.get(i).gross, "**", list.get(i).fedTax, list.get(i).stateTax, list.get(i).fica, list.get(i).ueiDI, list.get(i).net, list.get(i).employerCost);
			else
				outputFile.printf("%12.2f %10.2f %10.2f %10.2f %10.2f %10.2f %10.2f\n", list.get(i).gross, list.get(i).fedTax, list.get(i).stateTax, list.get(i).fica, list.get(i).ueiDI, list.get(i).net, list.get(i).employerCost);
			
			//accumulators 
			hrs += list.get(i).hrs;
			gross += list.get(i).gross;
			fedTax += list.get(i).fedTax;
			stateTax += list.get(i).stateTax;
			fica += list.get(i).fica;
			ueiDI += list.get(i).ueiDI;
			net += list.get(i).net;
			employerCost += list.get(i).employerCost;
		}
		//total amount and number of employees processed
		outputFile.printf("%s %11.1f %11.2f %10.2f %10.2f %10.2f %10.2f %10.2f %10.2f\n", "Totals:", hrs, gross, fedTax, stateTax, fica, ueiDI, net, employerCost);
		outputFile.println();
		outputFile.printf("%s %11d", "Employees paid:", list.size());
		
		outputFile.close();
		
		//print to console 
		System.out.printf("%35s %8.1f\n", "Total of hours:", hrs);
		System.out.printf("%35s %9.2f\n", "Total of gross pay:", gross);
		System.out.printf("%35s %9.2f\n", "Total of federal tax:", fedTax);
		System.out.printf("%35s %9.2f\n", "Total of state tax:", stateTax);
		System.out.printf("%35s %9.2f\n", "Total FICA:", fica);
		System.out.printf("%35s %9.2f\n", "Total net pay:", net);
		System.out.printf("%32s %9.2f\n", "Total employer's FICA contribution:", fica);
		System.out.printf("%35s %9.2f\n", "Total employer's UEI contribution:", ueiDI);
		System.out.printf("%35s %9.2f\n", "Total cost to Employer:", employerCost);
		System.out.printf("%35s %6d\n", "Number of employees processed:", list.size());
	}
}

