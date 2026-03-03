//packages
package edu.norcocollege.cis18b.week2.demo;
//imports
import java.util.List;
/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
//Begins Here
public class ModernFeaturesDemo {
    //Record type for Bank Account
    record BankAccount(String user, double balance, String accountNum){}
    //Demonstrate All Functions
    public void demonstrate(){
        //Multiple Bank Accounts
        List<BankAccount> accounts = List.of(
            new BankAccount("James Bond", 1000.0, "007-007"),
            new BankAccount("John Doe", 500.0, "123-456"),
            new BankAccount("Rick Sanchez", 2000.0, "666-666")
        );
        //Pattern Matching with instanceof
        Object obj = accounts.get(0);
        String SelectedAccountNumber = "666-666";
         if(obj instanceof BankAccount account && account.accountNum().equals(SelectedAccountNumber)){
            System.out.println("Pattern matches account: " + account.user() +"s account number is " + account.accountNum());
         }else{
            System.out.println("No match found for account number: " + SelectedAccountNumber);
         }
        //Enhanced Switch Expression
         for(BankAccount account : accounts){
            String accountType = switch(account.balance()){
                case double b when b > 1500 -> "Premium";
                case double b when b > 500 -> "Standard";
                case double b when b <= 0 -> "Empty";
                default -> "Basic";
            };
            System.out.println(account.user() + " has a " + accountType + " account.");
         }
}