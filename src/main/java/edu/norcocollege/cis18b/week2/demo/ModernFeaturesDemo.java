//packages
package edu.norcocollege.cis18b.week2.demo;
//imports
import java.util.List;
import java.util.stream.Collectors;
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
            new BankAccount("Rick Sanchez", 2000.0, "666-666"),
            new BankAccount("Spongebob Squarepants", 0.0, "777-777")
        );
        //Pattern Matching with instanceof
        Object obj = accounts.get(0);
        String SelectedAccountNumber = "222-222";
        //display pattern matching results
        System.out.println("Searching for account number: " + SelectedAccountNumber);
        System.out.println("===============================");
         if(obj instanceof BankAccount account && account.accountNum().equals(SelectedAccountNumber)){
            System.out.println("Pattern matches account: " + account.user() +"'s account number is " + account.accountNum());
         }else{
            System.out.println("No match found for account number: " + SelectedAccountNumber);
         }
        //Switch Expression
        System.out.println("===============================");
        System.out.println("Classifying accounts based on account number:");
        System.out.println("===============================");
         for(BankAccount account : accounts){
            String accountType = switch(account.accountNum()){
                case "007-007" -> "Premium";
                case "123-456" -> "Standard";
                case "666-666" -> "VIP";
                case "777-777" -> "Empty";
                default -> "Unknown";
            };
            System.out.println(account.user() + " has a " + accountType + " account.");
         }
         //Stream operations to filter and map accounts
        System.out.println("===============================");
        System.out.println("Accounts with a positive balance:");
        List<String> positiveAccounts = accounts.stream()
            .filter(acc -> acc.balance() > 0)
            .map(BankAccount::user)
            .collect(Collectors.toList());
            System.out.println("===============================");
            System.out.println(positiveAccounts);
         //Text Blocks for reporting
            String report = """
                == Bank Account Report ==
                Total Accounts: %d
                Positive Balance Accounts: %d
                =========================
                """.formatted(accounts.size(), positiveAccounts.size());
            System.out.println(report);
        }
}