package accounts;

public class CreditAccount extends Account {

    public CreditAccount(long balance, String name, String holder) {
        super(balance, name, holder);
    }

    @Override
    public boolean add(long amount) {

        if ((balance + amount) < 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }

}
