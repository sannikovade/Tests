package accounts;

public class SavingsAccount extends Account {
    protected long minimalBalance;

    public SavingsAccount(long balance, String name, String holder, long minimalBalance) {
        super(balance, name, holder);
        this.minimalBalance = minimalBalance;
    }

    @Override
    public boolean pay(long amount) {

        if (balance - amount >= minimalBalance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

}
