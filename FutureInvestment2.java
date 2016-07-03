// File: FutureInvestment2.java
// Due Date: Monday 7/4/16

/********************************************************************************************************
 * FutureInvestment2 Program - CSC 225 Program 2
 * Course Title: Advanced Java Programming
 * Course Number: CSC 225-805
 * Instructors: Professors Christine Forde and Harry Payne
 * @author Anna Ekeren
 * @author Rafael Ferrer
 * @author Abhishek Mhatre
 * @version 1.0, 06/30/16
 * 
 * Description: FutureInvestment2 Program - FutureInvestment2 Driver Class - CSC 225 Project 2
 * The FutureInvestment2 class is a GUI driver class that allows users to enter information about 
 * an Investment and then calculate its future value. This class is used in conjunction with the 
 * Investment data type class, which defines an Investment object. An Investment has an initial 
 * investment amount, number of years invested, and an annual interest percentage rate. 
 * 
 * Calculations: 
 * Calculates the future value of an investment based on the initial investment amount, 
 * the number of years invested, and the monthly interest rate of the Investment.
 * 
 * Equation:
 * This calculation is performed in the Investment class and called in the FutureInvestment2 class. 
 * investmentAmount * (1 + monthlyInterestRate)^(yearsInvested * 12)
 * Where monthlyInterestRate = (annualInterest% / 100) / 12
 * 
 * Example: A $10,000.00 investment for 1 year at an annual interest rate of 6.75% 
 * $10,000.00 * (1 + 0.005625)^(1*12) = $10,696.28
 * 
 ********************************************************************************************************/




import javax.swing.*; //Needed for GUI Elements
import java.awt.event.ActionEvent; //Needed for GUI Action Events
import java.awt.event.ActionListener; //Needed for GUI Action Events
import java.text.DecimalFormat; //Needed for Monetary Output Formatting


public class FutureInvestment2 implements ActionListener {
	
	/// Private Instance Variables for GUI ///
	
	//Primary Window Elements
	private JFrame primaryWindow;    //GUI's primary window 
	private JLabel amountLabel;      //Label for amountField 
	private JTextField amountField;  //Input - The amount of money the user wants to invest 
	private JLabel yearsLabel;       //Label for yearsField 
	private JTextField yearsField;   //Input - The number of years the user will invest their money for 
	private JLabel rateLabel;        //Label for rateField 
	private JTextField rateField;    //Input - The annual interest percentage rate of the investment 
	private JLabel valueLabel;       //Label for valueField 
	private JTextField valueField;   //Output - The dollar value of the Investment after it has fully matured 
	private JButton calculateButton; //Action - Outputs valueField 
	private JButton clearButton;     //Action - Clears amountField, yearsField, rateField, and valueField 
	
	//Primary Menu Bar Elements
	private JMenuBar primaryMenuBar;     //Primary window's primary menu bar
	private JMenu operationMenu;         //Sub-menu - Contains calculateMenuItem and exitMenuItem 
	private JMenuItem calculateMenuItem; //Action - Outputs valueField 
	private JMenuItem exitMenuItem;      //Action - Closes program
	private JMenu helpMenu;              //Sub-menu - Contains aboutMenuItem
	private JMenuItem aboutMenuItem;     //Action - Opens new information window
	
	
	
	
	/// Main Method ///
	
	/**
	 * The Main method creates a new instance of the FutureInvestment2 program.
	 * @postcondition
	 *   The FutureInvestment2 GUI has been launched and will remain open until the user closes it.  
	 **/
	public static void main(String[] args){
		
		FutureInvestment2 runProgram = new FutureInvestment2();

	}//End Main Method
	
	
	
	
	/// Primary GUI - Constructor ///
	
	/**
	 * This constructor creates a new instance of the FutureInvestment2 program.
	 * @postcondition
	 *   A new instance of the FutureInvestment2 window has been constructed and
	 *   displayed to the user. If the user enters values for an investment and 
	 *   chooses the calculate button or menu item, then the investment's future 
	 *   value will be returned to the user. If the user chooses the clear button, 
	 *   then all the input and output fields will be cleared. If the user chooses 
	 *   the about menu item, then a new information window will appear. If the user
	 *   chooses the exit menu item, then the program will close.
	 **/
	public FutureInvestment2(){
		
		//Create Primary Window Elements
		primaryWindow = new JFrame();
		amountLabel = new JLabel("Investment Amount");
		amountField = new JTextField();
		yearsLabel = new JLabel("Years");
		yearsField = new JTextField();
		rateLabel = new JLabel("Annual Interest Rate");
		rateField = new JTextField();
		valueLabel = new JLabel("Future value");
		valueField = new JTextField();
		valueField.setEditable(false); //Output Field - User cannot edit
		calculateButton = new JButton("Calculate");
		clearButton = new JButton("Clear");
		
		//Create Primary Menu Bar Elements
		primaryMenuBar = new JMenuBar();
		operationMenu = new JMenu("Operation");
		calculateMenuItem = new JMenuItem("Calculate");
		exitMenuItem = new JMenuItem("Exit");
		helpMenu = new JMenu("Help");
		aboutMenuItem = new JMenuItem("About");
		
		//Add Primary Window Elements
		primaryWindow.setJMenuBar(primaryMenuBar);
		primaryWindow.add(calculateButton);
		primaryWindow.add(clearButton);
		primaryWindow.add(amountLabel);
		primaryWindow.add(yearsLabel);
		primaryWindow.add(rateLabel);
		primaryWindow.add(valueLabel);
		primaryWindow.add(amountField);
		primaryWindow.add(yearsField);
		primaryWindow.add(rateField);
		primaryWindow.add(valueField);
		
		//Add Primary Menu Bar Elements
		primaryMenuBar.add(operationMenu);
		operationMenu.add(calculateMenuItem);
		operationMenu.add(exitMenuItem);
		primaryMenuBar.add(helpMenu);
		helpMenu.add(aboutMenuItem);
		
		//Set Bounds on Primary Window Elements
		calculateButton.setBounds(50, 110, 100, 25);
		clearButton.setBounds(160, 110, 75, 25);
		amountLabel.setBounds(0, 1, 140, 25);
		amountField.setBounds(144, 1, 140, 25);
		yearsLabel.setBounds(0, 27, 140, 25);
		yearsField.setBounds(144, 27, 140, 25);
		rateLabel.setBounds(0, 53, 140, 25);
		rateField.setBounds(144, 53, 140, 25);
		valueLabel.setBounds(0, 79, 140, 25);
		valueField.setBounds(144, 79, 140, 25);
		
		//Handle Action Events
		calculateButton.addActionListener(this);
		calculateMenuItem.addActionListener(this);
		clearButton.addActionListener(this);
		aboutMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		
		//Finish creating the primary window and display it
		primaryWindow.setTitle("Future Investment Value");
		primaryWindow.setSize(300, 200);
		primaryWindow.setLocation(500, 300);
		primaryWindow.setLayout(null); //Using no layout managers
		primaryWindow.setVisible(true);
		primaryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//End main Method
	
	
	
	
	/// Action Event Methods ///
	
	/**
	 * This method reads action events and calls the appropriate action method
	 * that corresponds to each action event. 
	 * @postcondition
	 *   Any action event that occurs has been evaluated and the appropriate 
	 *   corresponding action method has been called. 
	 * @note
	 *   Action Event -> Corresponding Action Method:
	 *   <p>
	 *   Calculate Button -> caluclateValue()
	 *   <p>
	 *   Calculate Menu Item -> caluclateValue()
	 *   <p>
	 *   Clear Button -> clearFields()
	 *   <p>
	 *   About Menu Item -> displayAboutInfo()
	 *   <p>
	 *   Exit Menu Item -> exitProgram()
	 **/
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == calculateButton || e.getSource() == calculateMenuItem){
			caluclateValue();
		}
		else if (e.getSource() == clearButton){
			clearFields();
		}
		else if (e.getSource() == aboutMenuItem){
			displayAboutInfo();
		}
		else if (e.getSource() == exitMenuItem){
			exitProgram();
		}
		
	}//End actionPerformed(ActionEvent e) Method
   
	
	/**
	 * This action method reads the user's input about an investment and then calculates
	 * the future value of the investment. It then displays that value to the user.
	 * @precondition
	 *   The user input for the investment must be legal. No future value will be 
	 *   calculated if letters, characters or non-decimal values are entered.
	 *   All values must be less than (and calculate a value less than) Double.MAX_VALUE.
	 * @postcondition
	 *   The future value of the investment has been calculated and displayed to the user.
	 *   If the user's input was illegal, nothing will happen.
	 * @note
	 *   If the user enters any illegal values, then the Future Value output field 
	 *   will fail to display any value. The program will continue running and the 
	 *   user may clear all fields and enter new legal values. No explicit exceptions 
	 *   or errors are caught or thrown in the FutureInvestment2 class. 
	 **/
	private void caluclateValue(){
		
		//Instance Variables
		Investment newInvestment; //The Investment object created with the user's input
		double investmentAmount; //The amount of money the user wants to invest 
		double yearsInvested; //The number of years the user will invest their money for
		double annualInterestPercent; //The annual interest percentage rate of the investment
		DecimalFormat cashDF = new DecimalFormat("$0.00"); //Decimal output format for valueField
		
		//Read the user's input values from the text fields and assign those values to their 
		//corresponding instance variable
		investmentAmount = Double.parseDouble(amountField.getText());
		yearsInvested = Double.parseDouble(yearsField.getText());
		annualInterestPercent = Double.parseDouble(rateField.getText());
		
		//Create the Investment object with the user specified values
		newInvestment = new Investment(investmentAmount, yearsInvested, annualInterestPercent);
		
		//Calculate and display the future value to the user
		valueField.setText(cashDF.format(newInvestment.caluclateFutureValue()));
		
	}//End caluclateValue() Method
   
   
	/**
	 * This action method clears all of the input and output fields of the GUI.
	 * @postcondition
	 *   All text in the input and output fields of the GUI has been deleted. 
	 **/
	private void clearFields(){
		
		amountField.setText("");
		yearsField.setText("");
		rateField.setText("");
		valueField.setText("");
	
	}//End clearFields() Method
	
	
	/**
	 * This action method displays a new information message window with 
	 * information about this program. 
	 * @postcondition
	 *   A new information message window with information about this program 
	 *   has been displayed. 
	 **/
	private void displayAboutInfo(){
		
		JOptionPane.showMessageDialog(null, 
				"Compute Future Investment Value", 
				"About This Program", 
				JOptionPane.INFORMATION_MESSAGE);
	
	}//End displayAboutInfo() Method 
	
	
	/**
	 * This action method closes the FutureInvestment2 program. 
	 * @postcondition
	 *   The FutureInvestment2 GUI has been closed and the program has ended.
	 **/
	private void exitProgram(){
		
		System.exit(0);
	
	}//End exitProgram() Method
	
	
}//End FutureInvestment2 Class

