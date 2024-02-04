import java.util.Scanner;

class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance > 0.0)
            balance = initialBalance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Insufficient funds.");
    }

    public double getBalance() {
        return balance;
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account account = new Account(0.0);

        int choice;
        double amount;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your account balance is: %.2f\n", account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ");
                    amount = input.nextDouble();
                    account.credit(amount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: ");
                    amount = input.nextDouble();
                    account.debit(amount);
                    System.out.println("Withdrawal successful.");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        input.close();
    }
}