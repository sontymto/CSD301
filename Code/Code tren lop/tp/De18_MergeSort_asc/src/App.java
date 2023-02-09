import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        InputData inputData = new InputData();
        // int number_account = inputData.input_int("Enter number of account", sc);
        Account[] accounts = new Account[5];

        // for (int i = 0; i < accounts.length; i++) {
        //     System.out.println("Account number " + (i + 1)+":");
        //     String owner = inputData.input_string("Enter owner", sc);           
        //     String number = inputData.input_string("Enter number", sc);
        //     double balance = inputData.input_double("Enter balance", sc);
        //     accounts[i] = new Account(number, owner, balance);
        // }
        
        accounts[0] = new Account("0009342", "A", 1000);
        accounts[1] = new Account("0009343", "A", 2000);
        accounts[4] = new Account("0009344", "C", 3000);
        accounts[2] = new Account("4534543", "D", 4000);
        accounts[3] = new Account("0009342", "D", 9000);
        
        // Display list of account before sorting
        System.out.println("List of account before sorting:");
        for (Account account : accounts) {
            System.out.println(account);
        }

        // Sort list of account
        SortAccount.mergeSort(accounts, 0, 5-1); 

        // Display list of account after sorting
        System.out.println("List of account after sorting:");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
