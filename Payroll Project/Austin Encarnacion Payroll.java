/*
Austin Encarnacion
Math 130-03
Instructor: Mimi Rasky
11/25/2022
Project 5 Payroll
*/
package payroll;

public class Payroll 
{
	public double hrs, rate, gross, net, fedTax, stateTax, fica, ueiDI, employerCost;
	public boolean overtimeFlag;
	
	public Payroll(double rate, double hrs) 
	{
		this.rate = rate;
		this.hrs = hrs;
		setTheOthers();
	}
	
	public void setTheOthers()
	{
		//Check to see if employee worked overtime
		if (this.hrs > 40)
			this.overtimeFlag = true;
		else
			this.overtimeFlag = false;
		
		//calculations if overtime is true
		if(this.overtimeFlag)
			this.gross = this.rate * 40 + (this.hrs - 40) * (this.rate * 1.5);
		else
			this.gross = this.hrs * this.rate;
		
		//Calculate and fill array
		this.fedTax = this.gross * 0.25;
		this.stateTax = this.gross * 0.09075;
		this.fica = this.gross * 0.0765;
		this.ueiDI = this.gross * 0.02;
		this.net = this.gross - this.fedTax - this.stateTax - this.fica;
		this.employerCost = this.gross + this.fica + this.ueiDI;
	}
}
