package banking;

import java.util.Scanner;

/**
 * BankingApp is the main console-based user interface for the banking system.
 * It provides a menu-driven interface for users to interact with bank accounts.
 */
public class BankingApp {
    private Bank bank;
    private Scanner scanner;

    /**
     * Constructor to initialize the banking application
     */
    public BankingApp() {
        this.bank = new Bank();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Start the banking application
     */
    public void run() {
        displayWelcome();

        while (true) {
            showMainMenu();
            int choice = getValidChoice(1, 4);

            switch (choice) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    accessExistingAccount();
                    break;
                case 3:
                    bank.displayAllAccounts();
                    break;
                case 4:
                    displayExit();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }

    /**
     * Display welcome banner
     */
    private void displayWelcome() {
        System.out.println("\n★".repeat(40));
        System.out.println("   Welcome to Banking System");
        System.out.println("★".repeat(40) + "\n");
    }

    /**
     * Display exit banner
     */
    private void displayExit() {
        System.out.println("\n★".repeat(40));
        System.out.println("Thank you for using Banking System!");
        System.out.println("Have a great day!");
        System.out.println("★".repeat(40) + "\n");
    }

    /**
     * Display main menu
     */
    private void showMainMenu() {
        System.out.println("=".repeat(60));
        System.out.println("           ★ WELCOME TO BANKING SYSTEM ★");
        System.out.println("=".repeat(60));
        System.out.println("1. Create New Account");
        System.out.println("2. Access Existing Account");
        System.out.println("3. View All Accounts");
        System.out.println("4. Exit");
        System.out.println("=".repeat(60));
        System.out.print("Select an option (1-4): ");
    }

    /**
     * Display account operations menu
     */
    private void showAccountMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              ★ ACCOUNT OPERATIONS ★");
        System.out.println("=".repeat(60));
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Display Account Information");
        System.out.println("5. Back to Main Menu");
        System.out.println("=".repeat(60));
        System.out.print("Select an option (1-5): ");
    }

    /**
     * Handle account creation
     */
    private void createNewAccount() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    CREATE NEW ACCOUNT");
        System.out.println("=".repeat(60));

        try {
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter initial balance: $");
            double balance = getValidAmount();

            bank.createAccount(name, balance);

        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage() + "\n");
        } catch (Exception e) {
            System.out.println("✗ Unexpected error: " + e.getMessage() + "\n");
        }
    }

    /**
     * Handle accessing existing account
     */
    private void accessExistingAccount() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                   ACCESS EXISTING ACCOUNT");
        System.out.println("=".repeat(60));

        try {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine().trim();

            Account account = bank.findAccount(accountNumber);
            System.out.println("\n✓ Account found!\n");

            accountOperations(account);

        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage() + "\n");
        } catch (Exception e) {
            System.out.println("✗ Unexpected error: " + e.getMessage() + "\n");
        }
    }

    /**
     * Handle account operations menu
     *
     * @param account The account to perform operations on
     */
    private void accountOperations(Account account) {
        while (true) {
            showAccountMenu();
            int choice = getValidChoice(1, 5);

            switch (choice) {
                case 1:
                    depositMoney(account);
                    break;
                case 2:
                    withdrawMoney(account);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.displayAccountInfo();
                    break;
                case 5:
                    System.out.println("Returning to main menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }

    /**
     * Handle money deposit
     *
     * @param account The account to deposit money into
     */
    private void depositMoney(Account account) {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("                    DEPOSIT MONEY");
        System.out.println("-".repeat(60));

        try {
            System.out.print("Enter deposit amount: $");
            double amount = getValidAmount();
            account.deposit(amount);

        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage() + "\n");
        } catch (Exception e) {
            System.out.println("✗ Unexpected error: " + e.getMessage() + "\n");
        }
    }

    /**
     * Handle money withdrawal
     *
     * @param account The account to withdraw money from
     */
    private void withdrawMoney(Account account) {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("                    WITHDRAW MONEY");
        System.out.println("-".repeat(60));

        try {
            System.out.print("Enter withdrawal amount: $");
            double amount = getValidAmount();
            account.withdraw(amount);

        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage() + "\n");
        } catch (Exception e) {
            System.out.println("✗ Unexpected error: " + e.getMessage() + "\n");
        }
    }

    /**
     * Get valid monetary amount from user
     *
     * @return Valid positive double amount
     */
    private double getValidAmount() {
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.print("Amount must be positive. Please try again: $");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Please enter a valid number: $");
            }
        }
    }

    /**
     * Get valid menu choice from user
     *
     * @param min Minimum valid choice
     * @param max Maximum valid choice
     * @return Valid choice within range
     */
    private int getValidChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    /**
     * Main method to start the application
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        BankingApp app = new BankingApp();
        app.run();
    }
}