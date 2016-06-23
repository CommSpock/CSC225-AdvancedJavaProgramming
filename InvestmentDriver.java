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
 * @version 1.0, 06/23/16
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

import java.text.DecimalFormat;

import javafx.application.Application;
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


public class InvestmentDriver extends Application {
	
	//Private Instance Variables
	private GridPane gridPane = new GridPane();
	private TextField investmentAmountTF = new TextField();
	private TextField yearsInvestedTF = new TextField();
	private TextField annualInterestRateTF = new TextField();
	private TextField futureVauleTF = new TextField();
	private Button calculateBT = new Button("Calculate");
	private Button clearBT = new Button("Clear");
	private Label amount = new Label("Investment Amount");
	Scene scene = new Scene(gridPane);
	
	
	
	public void start(Stage primaryStage){
		
		//Create Menu Bar
		final Menu menu1 = new Menu("Operation");
		final Menu menu2 = new Menu("Help");
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2);
		menuBar.useSystemMenuBarProperty();
		
		MenuItem menu11 = new MenuItem("Calculate");
		menu11.setOnAction(e -> caluclateValue());
		MenuItem menu12 = new MenuItem("Exit");
		menu12.setOnAction(e -> System.exit(0));
		MenuItem menu22 = new MenuItem("About");
		menu1.getItems().add(menu11);
		menu1.getItems().add(menu12);
		menu2.getItems().add(menu22);
		
		
		
		//Create GUI
		gridPane.setHgap(0);
		gridPane.setVgap(0);
		gridPane.add(menuBar, 0, 0);
		gridPane.add(amount, 0, 1);
		gridPane.add(investmentAmountTF, 1, 1);
		gridPane.add(new Label("Years"), 0, 2);
		gridPane.add(yearsInvestedTF, 1, 2);
		gridPane.add(new Label("Annual Interest Rate"), 0, 3);
		gridPane.add(annualInterestRateTF, 1, 3);
		gridPane.add(new Label("Future Value"), 0, 4);
		gridPane.add(futureVauleTF, 1, 4);
		gridPane.add(calculateBT, 0, 5);
		gridPane.add(clearBT, 1, 5);		
		
		
		
		//Set Properties for GUI
		gridPane.setAlignment(Pos.CENTER);
		investmentAmountTF.setAlignment(Pos.BOTTOM_RIGHT);
		yearsInvestedTF.setAlignment(Pos.BOTTOM_RIGHT);
		annualInterestRateTF.setAlignment(Pos.BOTTOM_RIGHT);
		futureVauleTF.setAlignment(Pos.BOTTOM_RIGHT);
		futureVauleTF.setEditable(false);
		gridPane.setHalignment(calculateBT, HPos.RIGHT);
		gridPane.setHalignment(clearBT, HPos.LEFT);
		
		//Process Events
		calculateBT.setOnAction(e -> caluclateValue());
		clearBT.setOnAction(e -> clearFields());
		
		
		
		//Create a Scene in the Stage
		primaryStage.setTitle("Future Investment Value");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}//End start(Stage primaryStage) Method
	
	
	
	private void caluclateValue(){
		
		//Instance Variables
		Investment newInvestment;
		double investmentAmount;
		double yearsInvested;
		double annualInterestRate;
		DecimalFormat cashOutput = new DecimalFormat("$0.00"); //decimal output format for outputting account balances
		
		//Read Values from Text Fields
		investmentAmount = Double.parseDouble(investmentAmountTF.getText());
		yearsInvested = Double.parseDouble(yearsInvestedTF.getText());
		annualInterestRate = Double.parseDouble(annualInterestRateTF.getText());
		
		//Create the Investment Object
		newInvestment = new Investment(investmentAmount, yearsInvested, annualInterestRate);
		
		//Display the Future Value
		futureVauleTF.setText(cashOutput.format(newInvestment.caluclateFutureValue()));
		
	}//End caluclateValue() Method
	
	private void clearFields(){
		
		investmentAmountTF.clear();
		yearsInvestedTF.clear();
		annualInterestRateTF.clear();
		futureVauleTF.clear();
	}
	
	
	
}
