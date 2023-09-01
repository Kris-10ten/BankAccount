import java.util.Random;

public class BankAccount {
    private static int numAccounts = 0;
    private static double totalMoney = 0;
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = generateAccountNumber();

        numAccounts++;
        totalMoney += checkingBalance + savingsBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
    public void depositMoney(double deposit, String account) {
        if (account.equalsIgnoreCase("checking")) {
            checkingBalance += deposit;
        } else if (account.equalsIgnoreCase("savings")) {
            savingsBalance += deposit;
        } else {
            System.out.println("Choose either your checking or savings account to deposit money into.");
        }
    }
    public void withdrawMoney(double withdraw, String account) {
        if (account.equalsIgnoreCase("checking")) {
            if (checkingBalance < withdraw) {
                System.out.println("Insufficient funds.");
            } else {
                checkingBalance -= withdraw;
            }
        } else if (account.equalsIgnoreCase("savings")) {
            if (savingsBalance < withdraw) {
                System.out.println("Insufficient funds.");
            } else {
                checkingBalance -= withdraw;
            }
        }
    }
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumberBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accountNumberBuilder.append(random.nextInt(10));
        }
        return accountNumberBuilder.toString();
    }

    public static void main(String[] args) {

    }
}
