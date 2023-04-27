package accounts;

public abstract class Account implements MoneyTarget {
    protected long balance;
    protected String name;
    protected String holder;

    public Account(long balance, String name, String holder) {

        this.balance = balance;
        this.name = name;
        this.holder = holder;
    }

    public long getBalance() {
        return balance;
    }

    public abstract boolean pay(long amount);

    public abstract boolean add(long amount);

    public boolean transfer(Account accountTo, long amount) {

        if (pay(amount)) {
            if (accountTo.add(amount)) {
                System.out.println("Transaction from " + name + " to " + accountTo.name + " completed");
                return true;
            } else if (!accountTo.add(amount)) {
                System.out.println("Transaction from " + name + " to " + accountTo.name + " failed");
                add(amount);
                return true;
            }

        } else {
            System.out.println("Transaction from " + name + " to " + accountTo.name + " failed");
        }
        return false;
    }


    @Override
    public boolean accept(long money) {
        if (add(money)) {
            System.out.println(holder + " can accept " + money + " on " + name + " account");
            return true;
        } else {
            System.out.println(name + " account" + " can not accept " + money);
            return false;
        }

    }

    public String toString() {
        return balance + " on " + holder + "'s " + name + " account";
    }
}

