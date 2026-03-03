//Packages
package edu.norcocollege.cis18b.week2.demo;
//Imports
import java.util.List;
/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 */
//Begins Here
public class LanguageBasicsReview {
    //Variables
    private String User;
    private double balance;
    //two-arg Constructor
    public LanguageBasicsReview(String user, double balance){
        this.User = user;
        this.balance = balance;
    }
    //Deposit function
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited $" + amount);
    }
    //Overload Deposit
    public void deposit(double amount, String note){
        balance+=amount;
        System.out.println("Deposited $" + amount +" | Note: "+ note);
    }
    //withdraw Function
    public void withdraw(double amount)throws InsufficientFundsException{
        if(amount>balance){
            throw new InsufficientFundsException("Not enough funds in account!");
        }else{
            balance-=amount;
            System.out.println("withdraw $" + amount);
        }
    }
    //Calculate interest Function
    public static double calculateInterest(double balance, double rate){
        return balance*rate;
    } 
    //Getter
    public double getBalance(){
        return balance;
    }
    //Custom Exception Class
    class InsufficientFundsException extends Exception{
        public InsufficientFundsException(String message){
            super(message);
        }
    }
    //Demonstrate All Functions
    public void demonstrate(){
        //Create Var
        var account = new LanguageBasicsReview("Joe", 500.00f);
        //List using list.of
        List<String>transactionTypes=List.of("DEPOSIT","WITHDRAW","INTEREST");
        System.out.println("Possible Transactions: "+ transactionTypes);
        System.out.println("Current Balance: $" + account.getBalance());
        System.out.println();
        //Modern Switch expression
        String transaction = "DEPOSIT";
        switch(transaction){
            case "DEPOSIT" -> account.deposit(300, "Paycheck");
            case "WITHDRAW"-> {
                try{
                    account.withdraw(200);
                }catch(InsufficientFundsException e){
                    System.out.println("Error: " +e.getMessage());
                }
            }
            case "INTEREST"-> {
                double interest = calculateInterest(account.getBalance(), 0.05);
                account.deposit(interest, "Monthly Interest");
            }
            default -> System.out.println("Invalid Transaction Type!");
        }
        //Display Final Balance
        System.out.println();
        System.out.println("Final Balance: $" + account.getBalance());
        //Example Try/catch exception
        System.out.println();
        System.out.println("Attempting large withdrawal...");
        try{
            account.withdraw(5000);
        }catch(InsufficientFundsException e){
            System.out.println("Caught Exception: " + e.getMessage());
        }
        System.out.println("Final Balance: $" + account.getBalance());
    }
    public static void main(String[] args){
        new LanguageBasicsReview("Demo", 0).demonstrate();
    }
}