package accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    SavingsAccount savingsAccount = new SavingsAccount(10,"a","b", 1);

    @Test
    void testSavingsPay() {
        assertFalse(savingsAccount.pay(10));
    }

    @Test
    void testSavingIsMinBalance(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.setMinimalBalance(-20));
    }

    @Test
    void testSavingDoesAdd() {
        long param = 20;
        long expected = 30;
        savingsAccount.add(param);
        Assertions.assertEquals(savingsAccount.balance, expected);
    }
}