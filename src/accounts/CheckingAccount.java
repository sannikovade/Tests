package accounts;

public class CheckingAccount extends Account {

    public CheckingAccount(long balance, String name, String holder) {
        super(balance, name, holder);
    }

    @Override
    public boolean pay(long amount) {
        if ((balance - amount) >= 0) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }


}
