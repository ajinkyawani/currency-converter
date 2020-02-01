/*

CSCI 6617 S2 Fall 2019
Java Programming
Ajinkya Wani
awani1@unh.newhaven.edu
Instructor: Sheehan

NAME OF CLASS: Awani1_6617_HW1
DESCRIPTION: The class helps convert specified amount of one currency into another 
currency for user.

 */

package awani1_6617_hw1;

import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author ajinkyawani
 */
public class Awani1_6617_HW1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String continueChoice;
        int srcCurrencyChoice = 0;
        int endCurrencyChoice = 0;
        Scanner input;
        double amount = 0;
        boolean isValid = false;
        String quitChoice;
        
        String[] currencyNames = {
            "United States Dollars (USD)",
            "British Pounds (GBP)",
            "Swiss Franks (CHF)",
            "Indian Rupees (INR)"
        };
        
        double [][] conversionChart = {
            {1.000000, 1.227902, 1.012514, 0.013950},
            {0.814349, 1.000000, 0.824820, 0.011365},
            {0.987370, 1.212602, 1.000000, 0.013777},
            {71.687245, 88.022221, 72.582298, 1.000000}
        };
        
        System.out.println("Welcome to the currency converter program");

        do {
            // Code to ask user to enter choice to select source currency to convert from.
            do {
                System.out.println("\nKindly enter choice for currency you wish to convert from.");
                displayCurrencyOptions();
                
                input = new Scanner(System.in);
                
                if (input.hasNextInt()) {
                    srcCurrencyChoice = input.nextInt();
                    if (srcCurrencyChoice > 5 || srcCurrencyChoice < 1){ 
                        System.out.println("\nYou entered wrong choice, try again!");
                        isValid = false;
                    }
                    else
                        isValid = true;
                }
                else {
                    System.out.println("\nInvalid choice, only integer value is accepted, try again!");
                    isValid = false;
                    input.next();
                }
                
            } while (!isValid);
            
            // Code to ask user to enter amount to be converted to another currency.
            if (srcCurrencyChoice != 5) {
                do {
                    System.out.println("\nEnter the amount to be converted or 'Quit' to exit");
                    input = new Scanner(System.in);
                    if (input.hasNextDouble()){
                        amount = input.nextDouble();
                        if (amount > 1000000){
                            System.out.println("\nAmount shouldn't be more than one million, try again!");
                            isValid = false;
                        }
                        else
                            isValid = true;
                    }
                    else if(input.hasNextLine()){ 
                        quitChoice = input.nextLine();
                        if(quitChoice.equals("Quit")){
                            System.out.println("\nThank you for using Currency Converter program, visit again!");
                            System.exit(0);
                        }
                        else
                            isValid = false;
                    }
                    
                } while (!isValid);
                
                // Code to ask user to choose result currency.
                do {
                    System.out.println("\nKindly enter choice for currency you wish to convert to.");
                    displayCurrencyOptions();
                    input = new Scanner(System.in);
                    if(input.hasNextInt()){
                        endCurrencyChoice = input.nextInt();
                        if (endCurrencyChoice == 5) {
                            System.out.println("\nThank you for using currency converter program");
                            System.exit(0);
                        }
                        else if (srcCurrencyChoice == endCurrencyChoice){
                            System.out.println("\nBoth source and end currency cannot be same, try again!");
                            isValid = false;
                        }
                        else if(endCurrencyChoice > 5 || endCurrencyChoice < 0){
                            System.out.println("\nYou entered wrong choice, try again!");
                            isValid = false;
                        }
                        else
                            isValid = true;
                    }
                    else{
                        isValid = false;
                    }
                    
                } while(!isValid);
                
                // Logic to convert currency from one selected to currency to another.
                double convertedAmount = amount * conversionChart[endCurrencyChoice - 1][srcCurrencyChoice - 1];
                System.out.println("\nResultant amount : " + String.format("%.2f", convertedAmount) + " " 
                    + currencyNames[endCurrencyChoice - 1]
                    + "\tRequested amount : " + String.format("%.2f", convertedAmount) + " " 
                    + currencyNames[srcCurrencyChoice - 1]);
            }
            else {
                System.out.println("\nThank you for using currency converter program, visit again!");
                System.exit(0);
            }
            
            // Code to ask user if he wishes to continue using program or exit it.
            do {
                System.out.println("\nDo you wish to continue?"
                        + " Enter 'Yes' or 'No' ");
                input = new Scanner(System.in);
                if(input.hasNextLine()){
                    continueChoice = input.nextLine();
                    switch (continueChoice) {
                        case "Yes":
                            isValid = true;
                            break;
                        case "No":
                            System.out.println("\nThank you for using currency converter program, visit again!");
                            System.exit(0);
                        default:
                            isValid = false;
                            break;
                    }
                }
            } while (!isValid);
            
        } while(isValid);
        
    }
    /**
     * Dis[lay currency options to user
     */
    public static void displayCurrencyOptions(){
    System.out.println("\n1. United States Dollars (USD)"
                    + "\n2. British Pounds (GBP)"
                    + "\n3. Swiss Francs (CHF)"
                    + "\n4. Indian Rupees (INR)"
                    + "\n5. Exit\n");
    }
    
}
