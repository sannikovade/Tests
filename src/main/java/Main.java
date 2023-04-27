import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;

public class Main {

    public static void main(String[] args) {
        Client client = new Client("Ivan", 5);
        long income = 300;
        long expenses = 1150;
        CheckingAccount check = new CheckingAccount(income, "checking", client.getName());
        SavingsAccount save = new SavingsAccount(300, "savings", client.getName(), 100);
        CreditAccount credit = new CreditAccount(0, "credit", client.getName());
        System.out.println(client.getName() + ". Income: " + income + ", expenses: " + expenses + "\n" + check + "\n" + save + "\n" + credit);

        client.add(check);
        client.add(save);
        client.add(credit);

        long residual = income - expenses;

        if (income >= expenses | save.getBalance() >= expenses) {
            client.pay(expenses);
        } else {
            check.pay(expenses + residual);
            income = 0;
            credit.add(residual);
        }

        save.transfer(credit, 400);
        credit.transfer(save, 3000);


        System.out.println(client.getName() + "\n" + check + "\n" + save + "\n" + credit);

        client.accept(3000);
        credit.accept(10000);

    }

}
