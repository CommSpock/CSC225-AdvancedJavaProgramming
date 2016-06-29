// File: InvestmentDriver.java
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
 * Description: FutureInvestment2 Investment GUI Driver - CSC 225 Project 2
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 ********************************************************************************************************/




import javafx.application.Application; //Superclass of InvestmentDriver (the program is run here)
import javafx.geometry.HPos; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class InvestmentDriver extends Application {
	
	//Private Instance Variables (Also an outline of the main window of our program)
	private GridPane primaryWindow = new GridPane(); //The main window of the InvestmentDriver program
	private Scene primaryScene = new Scene(primaryWindow); //The main scene of the InvestmentDriver program, containing primaryWindow
	
	private MenuBar primaryMenuBar = new MenuBar(); //The main menu bar of primaryWindow
	
	private Menu operationMenu = new Menu("Operation"); //A drop-down menu in primaryMenuBar 
	private MenuItem calculateMI = new MenuItem("Calculate"); //First option in operationMenu - Initiates the future value calculation
	private MenuItem exitMI = new MenuItem("Exit"); //Second option in operationMenu - Closes the program
	
	private Menu helpMenu = new Menu("Help"); //A drop-down menu in primaryMenuBar 
	private MenuItem aboutMI = new MenuItem("About"); //First option in helpMenu - Displays information about this program in a new pop-up window
	
	private TextField investmentAmountTF = new TextField(); //The text field (TF) where the user enters the investment amount
	private Label investmentAmountLB = new Label("Investment Amount"); //Label (LB) for investmentAmountTF
	
	private TextField yearsInvestedTF = new TextField(); //The text field (TF) where the user enters the length of the investment in years
	private Label yearsInvestedLB = new Label("Years"); //Label (LB) for yearsInvestedTF
	
	private TextField annualInterestPercentTF = new TextField(); //The text field (TF) where the user enters the annual interest percentage for the investment
	private Label annualInterestPercentLB = new Label("Annual Interest Rate"); //Label (LB) for annualInterestPercentTF
	
	private TextField futureVauleTF = new TextField(); //The text field (TF) that displays the calculated future value of the investment
	private Label futureVauleLB = new Label("Future Value"); //Label (LB) for futureVauleTF
	
	private Button calculateBT = new Button("Calculate"); //The button (BT) that initiates the future value calculation
	private Button clearBT = new Button("Clear"); //The button (BT) that clears all the text fields
	
	
	
	
	/**
	 * Description
	 * @param
	 *   
	 * @precondition
	 *   
	 * @postcondition / return
	 *   
	 * @exception
	 *   
	 * @note
	 *   
	 **/
	public void start(Stage primaryStage){
		
		//Setup the Stage and Scene
		primaryStage.setTitle("Future Investment Value");
		primaryStage.setScene(primaryScene);
		primaryStage.show();
		
		
		//Setup the Main Window Layout
		primaryWindow.setHgap(0);
		primaryWindow.setVgap(0);
		primaryWindow.setAlignment(Pos.CENTER);
		
		primaryWindow.add(primaryMenuBar, 0, 0);
		
		primaryWindow.add(investmentAmountLB, 0, 1);
		primaryWindow.add(investmentAmountTF, 1, 1);
		investmentAmountTF.setAlignment(Pos.BOTTOM_RIGHT);
		
		primaryWindow.add(yearsInvestedLB, 0, 2);
		primaryWindow.add(yearsInvestedTF, 1, 2);
		yearsInvestedTF.setAlignment(Pos.BOTTOM_RIGHT);
		
		primaryWindow.add(annualInterestPercentLB, 0, 3);
		primaryWindow.add(annualInterestPercentTF, 1, 3);
		annualInterestPercentTF.setAlignment(Pos.BOTTOM_RIGHT);
		
		primaryWindow.add(futureVauleLB, 0, 4);
		primaryWindow.add(futureVauleTF, 1, 4);
		futureVauleTF.setEditable(false);
		futureVauleTF.setAlignment(Pos.BOTTOM_RIGHT);
		
		primaryWindow.add(calculateBT, 0, 5);
		GridPane.setHalignment(calculateBT, HPos.RIGHT);
		
		primaryWindow.add(clearBT, 1, 5);
		GridPane.setHalignment(clearBT, HPos.LEFT);
		
		
		//Setup the Main Menu Bar
		primaryMenuBar.getMenus().addAll(operationMenu, helpMenu);
		primaryMenuBar.useSystemMenuBarProperty();
		
		
		//In the Main Menu Bar - Setup the menu choices under the Operation Menu
		calculateMI.setOnAction(e -> caluclateValue());
		operationMenu.getItems().add(calculateMI);
		exitMI.setOnAction(e -> System.exit(0));
		operationMenu.getItems().add(exitMI);
		
		
		//In the Main Menu Bar - Setup the menu choices under the Help Menu
		aboutMI.setOnAction(e -> displayAboutInfo());
		helpMenu.getItems().add(aboutMI);
		
		
		//Process Button Events
		calculateBT.setOnAction(e -> caluclateValue());
		clearBT.setOnAction(e -> clearFields());
		
		
	}//End start(Stage primaryStage) Method
	
	
	
	
	/**
	 * Description
	 * @param
	 *   
	 * @precondition
	 *   
	 * @postcondition / return
	 *   
	 * @exception
	 *   
	 * @note
	 *   
	 **/
	private void caluclateValue(){
		
		//Instance Variables
		Investment newInvestment; //
		double investmentAmount; //
		double yearsInvested; //
		double annualInterestPercent; //
		DecimalFormat cashOutput = new DecimalFormat("$0.00"); //decimal output format for outputting account balances
		
		
		//Read Values from Text Fields
		investmentAmount = Double.parseDouble(investmentAmountTF.getText());
		yearsInvested = Double.parseDouble(yearsInvestedTF.getText());
		annualInterestPercent = Double.parseDouble(annualInterestPercentTF.getText());
		
		
		//Create the Investment Object
		newInvestment = new Investment(investmentAmount, yearsInvested, annualInterestPercent);
		
		
		//Display the Future Value
		futureVauleTF.setText(cashOutput.format(newInvestment.caluclateFutureValue()));
		
		
	}//End caluclateValue() Method
	
	
	
	
	/**
	 * Description
	 * @param
	 *   
	 * @precondition
	 *   
	 * @postcondition / return
	 *   
	 * @exception
	 *   
	 * @note
	 *   
	 **/
	private void clearFields(){
		
		investmentAmountTF.clear();
		yearsInvestedTF.clear();
		annualInterestPercentTF.clear();
		futureVauleTF.clear();
		
	}//End clearFields() Method
	
	
	
	
	/**
	 * Description
	 * @param
	 *   
	 * @precondition
	 *   
	 * @postcondition / return
	 *   
	 * @exception
	 *   
	 * @note
	 *   
	 **/
	private void displayAboutInfo(){
		
		JOptionPane.showMessageDialog(null, 
				"Compute Future Investment Value", 
				"Abount This Program", JOptionPane.INFORMATION_MESSAGE);
		
	}//End displayAboutInfo() Method
	
	
}//End InvestmentDriver Class

