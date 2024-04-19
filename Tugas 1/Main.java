import java.util.Scanner;

class Customer {
    private double balance;
    private String customerNumber;
    private String name;

    public Customer(double balance, String customerNumber, String name) {
        this.balance = balance;
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }
}

class TransactionManager {
    private Customer customer;
    private int authAttempts;

    public TransactionManager(Customer customer) {
        this.customer = customer;
        this.authAttempts = 0;
    }

    public boolean purchase(double amount, String pin) {
        if (authenticate(pin)) {
            double cashbackRate = getCashbackRate(amount);
            double cashback = amount * cashbackRate;
            customer.setBalance(customer.getBalance() + amount - cashback);
            return true;
        } else {
            return false;
        }
    }

    public boolean topUp(double amount, String pin) {
        if (authenticate(pin)) {
            customer.setBalance(customer.getBalance() + amount);
            return true;
        } else {
            return false;
        }
    }

    private boolean authenticate(String pin) {
        // Dummy authentication logic, replace with actual implementation
        if (pin.equals("1234")) {
            authAttempts = 0; // Reset auth attempts on successful authentication
            return true;
        } else {
            authAttempts++;
            if (authAttempts >= 3) {
                // Freeze the account if 3 failed authentication attempts
                System.out.println("Account frozen due to multiple failed authentication attempts.");
                return false;
            } else {
                System.out.println("Incorrect PIN. Attempts left: " + (3 - authAttempts));
                return false;
            }
        }
    }

    private boolean isAccountFrozen() {
        return authAttempts >= 3;
    }

    public double getCashbackRate(double amount) {
        String customerNumberPrefix = customer.getCustomerNumber().substring(0, 2);
        if (amount > 1000000) {
            if (customerNumberPrefix.equals("38")) {
                return 0.05; // Silver customer cashback rate
            } else if (customerNumberPrefix.equals("56")) {
                return 0.07; // Gold customer cashback rate
            } else if (customerNumberPrefix.equals("74")) {
                return 0.10; // Platinum customer cashback rate
            }
        }
        return 0.02; // Default cashback rate
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter customer number:");
        String customerNumber = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();
        System.out.println("Set PIN for authentication:");
        String pin = scanner.next();

        Customer customer = new Customer(balance, customerNumber, name);
        TransactionManager transactionManager = new TransactionManager(customer);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Purchase");
            System.out.println("2. Top Up");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter purchase amount:");
                    double purchaseAmount = scanner.nextDouble();
                    System.out.println("Enter PIN for authentication:");
                    String purchasePin = scanner.next();
                    if (transactionManager.purchase(purchaseAmount, purchasePin)) {
                        System.out.println("Purchase successful.");
                    } else {
                        System.out.println("Purchase failed.");
                    }
                    break;
                case 2:
                    System.out.println("Enter top up amount:");
                    double topUpAmount = scanner.nextDouble();
                    System.out.println("Enter PIN for authentication:");
                    String topUpPin = scanner.next();
                    if (transactionManager.topUp(topUpAmount, topUpPin)) {
                        System.out.println("Top up successful.");
                    } else {
                        System.out.println("Top up failed.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
