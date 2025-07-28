
public class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.025;

    private static int savingsCount = 0;
    private int savingsNumber;

    public SavingsAccount(String name, double initialAmount) {
        super(name, initialAmount);
        savingsCount++;
        savingsNumber = savingsCount - 1;
        setAccountNumber(getAccountNumber() + "-" + savingsNumber);
    }

    public void postInterest() {
        double interest = getBalance() * INTEREST_RATE / 12;
        deposit(interest);
    }

    @Override
    public String getAccountNumber() {
        return super.getAccountNumber() + "-" + savingsNumber;
    }

    public SavingsAccount(SavingsAccount oldAccount, double initialAmount) {
        super(oldAccount, initialAmount);
        this.savingsNumber = oldAccount.savingsNumber + 1;
        setAccountNumber(oldAccount.getAccountNumber().substring(0, oldAccount.getAccountNumber().indexOf('-')) 
        + "-" + savingsNumber);
    }
}
