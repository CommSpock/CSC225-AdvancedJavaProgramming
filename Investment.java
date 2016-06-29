// File: Investment.java
// Due Date: Monday 7/4/16

/********************************************************************************************************
 * FutureInvestment2 Program - CSC 225 Program 2
 * Course Title: Advanced Java Programming
 * Course Number: CSC 225-805
 * Instructors: Professors Christine Forde and Harry Payne
 * @author Anna Ekeren
 * @author Rafael Ferrer
 * @author Abhishek Mhatre
 * @version 1.0, 06/29/16
 * 
 * Description: FutureInvestment2 Investment Data Type Class - CSC 225 Project 2
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 ********************************************************************************************************/




public class Investment{
	
	// Invariant of the Investment class:
	//   1. The investment amount is stored in the instance variable investmentAmount, 
	//		which must be a double (0.0). 
	//   2. The investment years is stored in the instance variable yearsInvested, 
	//		which must be a double (0.0). 
	//   3. The investment's annual interest rate is stored in the instance variable annualInterestRate, 
	//		which must be a double (0.0). This rate is twelve times the monthlyInterestRate.
	//		annualInterestRate is not a percentage amount.
	//   4. The investment's monthly interest rate is stored in the instance variable monthlyInterestRate, 
	//		which must be a double (0.0). This rate is 1/12 the annualInterestRate.
	//		monthlyInterestRate is not a percentage amount.
	
	//Private Instance Variables
	private double investmentAmount;
	private double yearsInvested;
	private double annualInterestRate;
	private double monthlyInterestRate;
	
	
	
	
	/// Constructors ///
	
	/**
	 * The default constructor that creates a new Investment object with an investment of $0 for 0 years.
	 * The default annual interest rate is 0 and the default monthly interest rate is 1/12 the annual rate.
	 * @postcondition
	 *   A new Investment object with has been created with the default parameters.
	 **/
	public Investment(){
	
		investmentAmount = 0;
		yearsInvested = 0;
		annualInterestRate = 0;
		monthlyInterestRate = annualInterestRate / 12;
		
	}//End Investment() Method
	
	
	/**
	 * A constructor that creates an Investment object with a specified investment amount, years invested, 
	 * and annual interest percentage rate.
	 * @param amount
	 *   The amount of money the user wants to invest.
	 * @param years
	 *   The number of years the user will invest their money for.
	 * @param annualInterestPercent
	 *   The annual interest percentage rate of the loan.
	 * @postcondition
	 *   A new Investment object has been created with the parameters specified by the user.
	 **/
	public Investment(double amount, double years, double annualInterestPercent){
		
		investmentAmount = amount;
		yearsInvested = years;
		annualInterestRate = annualInterestPercent / 100;
		monthlyInterestRate = annualInterestRate / 12;
		
	}//End Investment(double amount, double years, double annualInterestPercent) Method
	
	
	
	
	/// Accessor Methods for Private Instance Variables ///
	
	/**
	 * An accessor method that returns this Investment's amount invested.
	 * @return
	 *   Returns the amount money originally invested for this Investment.
	 **/
	public double getInvestmentAmount(){
		
		return investmentAmount;
		
	}//End getInvestmentAmount() Method
	
	
	/**
	 * An accessor method that returns this Investment's years invested.
	 * @return
	 *   Returns the number of years this Investment will be invested.
	 **/
	public double getYearsInvested(){
		
		return yearsInvested;
		
	}//End getYearsInvested() Method
	
	
	/**
	 * An accessor method that returns this Investment's annual interest rate.
	 * @return
	 *   Returns the annual interest rate of the invoking Investment. 
	 *   This is not a percentage amount.
	 **/
	public double getAnnualInterestRate(){
	
		return annualInterestRate;
		
	}//End getAnnualInterestRate() Method
	
	
	/**
	 * An accessor method that returns this Investment's monthly interest rate.
	 * @return
	 *   Returns the monthly interest rate of the invoking Investment. 
	 *   This is not a percentage amount.
	 **/
	public double getMonthlyInterestRate(){
		
		return monthlyInterestRate;
		
	}//End getMonthlyInterestRate() Method
	
	
	
	
	/// Mutator Methods for Private Instance Variables ///
	
	/**
	 * A mutator method that allows a user to change this Investment's original amount invested. 
	 * @param amount
	 *   The amount of money the user wishes to set as the original amount invested.
	 * @postcondition
	 *   The invoking Investment's original amount invested has been changed to amount.
	 **/
	public void setInvestmentAmount(double amount){
		
		investmentAmount = amount;
		
	}//End setInvestmentAmount(double InvestmentAmount) Method
	
	
	/**
	 * A mutator method that allows a user to change this Investment's years invested. 
	 * @param years
	 *   The number of years the user wishes to invest their money.
	 * @postcondition
	 *   The invoking Investment's years invested has been changed to years.
	 **/
	public void setYearsInvested(double years){
		
		yearsInvested = years;
		
	}//End setYears(double Years) Method
	
	
	/**
	 * A mutator method that allows a user to change this Investment's annual interest rate.
	 * @param annualInterestPercent
	 *   The annual interest percentage rate the user wishes to set for this Investment.
	 * @postcondition
	 *   The invoking Investment's annual interest rate has been changed to 
	 *   (annualInterestPercent / 100).
	 **/
	public void setAnnualInterestRate(double annualInterestPercent){
	
		annualInterestRate = annualInterestPercent / 100;
		
	}//End setAnnualInterestRate(double annualInterestPercent) Method
	
	
	/**
	 * A mutator method that allows a user to change this Investment's monthly interest rate.
	 * @param monthlyInterestPercent
	 *   The monthly interest percentage rate the user wishes to set for this Investment.
	 * @postcondition / return
	 *   The invoking Investment's monthly interest rate  has been changed to 
	 *   (monthlyInterestPercent / 100).
	 * @note
	 *   monthlyInterestPercent should be a double.
	 **/
	public void setMonthlyInterestRate(double monthlyInterestPercent){
		
		monthlyInterestRate = monthlyInterestPercent / 100;
		
	}//End setMonthlyInterestRate(double monthlyInterestPercent) Method
	
	
	
	
	/// Investment Calculation Methods ///
	
	/**
	 * This method calculates the future value of an Investment based on the initial investment amount, 
	 * the number of years invested, and the monthly interest rate of the Investment.
	 * @return
	 *   The dollar value of the Investment after it has fully matured. 
	 **/
	public double caluclateFutureValue(){
		
		return investmentAmount * Math.pow((1 + monthlyInterestRate), (yearsInvested * 12));
		
	}//End caluclateFutureValue() Method

	
}//End FutureInvestment2 Class

