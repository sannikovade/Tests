package clients;

import accounts.Account;
import accounts.MoneyTarget;

public class Client implements MoneyTarget {
    protected String name;
    protected Account[] accounts;

    public Client(String name, int maxAccNumber) {
        this.name = name;
        this.accounts = new Account[maxAccNumber];
    }

    @Override
    public boolean accept(long money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].accept(money)) {
                return true;
            }
        }
        System.out.println(name + " can not accept " + money);
        return false;
    }

    public String getName() {
        return name;
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Can't add new account. You've reached the maximum number of accounts");

    }

    public boolean pay(long amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].pay(amount)) {
                return true;
            }
        }
        return false;
    }


}
