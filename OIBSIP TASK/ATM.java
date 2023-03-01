import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Double> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        double balance = 0;

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. View balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction history");
            System.out.println("6. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your balance is $%.2f\n", balance);
                    break;
                case 2:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.printf("Deposit of $%.2f successful. New balance is $%.2f\n", depositAmount, balance);
                    transactionHistory.add(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter withdraw amount:");
                    double withdrawAmount = scanner.nextDouble();
                    if (balance < withdrawAmount) {
                        System.out.println("Insufficient funds.");
                    } else {
                        balance -= withdrawAmount;
                        System.out.printf("Withdrawal of $%.2f successful. New balance is $%.2f\n", withdrawAmount, balance);
                        transactionHistory.add(-withdrawAmount);
                    }
                    break;
                case 4:
                    System.out.println("Enter transfer amount:");
                    double transferAmount = scanner.nextDouble();
                    if (balance < transferAmount) {
                        System.out.println("Insufficient funds.");
                    } else {
                        System.out.println("Enter recipient account number:");
                        String recipient = scanner.next();
                        balance -= transferAmount;
                        System.out.printf("Transfer of $%.2f to account %s successful. New balance is $%.2f\n", transferAmount, recipient, balance);
                        transactionHistory.add(-transferAmount);
                    }
                    break;
                case 5:
                    System.out.println("Transaction history:");
                    for (double amount : transactionHistory) {
                        if (amount > 0) {
                            System.out.printf("Deposit of $%.2f\n", amount);
                        } else {
                            System.out.printf("Withdrawal of $%.2f\n", -amount);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

