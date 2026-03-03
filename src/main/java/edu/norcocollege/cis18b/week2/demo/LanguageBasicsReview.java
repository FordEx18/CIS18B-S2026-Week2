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
    private float balance;
    //Constructor
    public LanguageBasicsReview(String user, float balance){
        this.User = user;
        this.balance = balance;
    }
    //Deposit function
    public void deposit(float amount){
        balance+=amount;
        System.out.println("Deposited $" + amount);
    }
    //Overload Deposit
    public void deposit(float amount, String note){
        balance+=amount;
        System.out.println("Deposited $" + amount +" | Note: "+ note);
    }
    //withdraw Function
    public void withdraw(float amount)throws InsufficientFundsException{
        if(amount<balance){
            throw new InsufficientFundsException("Not enough funds in account!");
        }else{
            balance-=amount;
            System.out.println("withdraw $" + amount);
        }
    }
    //Calculate interest Function
    public static float calculateInterest(float balance, float rate){
        return balance*rate;
    } 
    //Getter
    public float getBalance(){
        return balance;
    }
}




    //Custom Exception Class
    class InsufficientFundsException extends Exception{
        public InsufficientFundsException(String message){
            super(message);
        }
    }
}