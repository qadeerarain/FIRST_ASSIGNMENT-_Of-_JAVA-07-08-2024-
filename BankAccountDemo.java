// Define the BankAccount class
class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(String accountNumber, double initialBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to check the balance
    public double getBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}

// Main class to demonstrate banking operations
public class BankAccountDemo {
    public static void main(String[] args) {
        // Create multiple BankAccount objects
        BankAccount account1 = new BankAccount("123456789", 1000.0, "John Doe");
        BankAccount account2 = new BankAccount("987654321", 2000.0, "Jane Smith");

        // Perform banking operations on account1
        System.out.println("Account 1 details:");
        account1.displayAccountDetails();
        account1.deposit(500.0);
        account1.withdraw(300.0);
        System.out.println("Balance after transactions: $" + account1.getBalance());

        // Perform banking operations on account2
        System.out.println("\nAccount 2 details:");
        account2.displayAccountDetails();
        account2.deposit(1000.0);
        account2.withdraw(2500.0);
        System.out.println("Balance after transactions: $" + account2.getBalance());
    }
}
