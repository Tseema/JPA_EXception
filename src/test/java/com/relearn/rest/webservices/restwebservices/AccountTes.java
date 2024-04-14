package com.relearn.rest.webservices.restwebservices;

import com.relearn.practice.Account;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountTes {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        assertEquals(0d, account.getOverdraftLimit(),epsilon);
    }

    @Test
    public void withdrawNegativetest(){
        Account account = new Account(-20);

        assertEquals(false, account.withdraw(-20));
    }

    @Test
    public void depositnegative(){
        Account account = new Account(-20);

        assertEquals(false,account.deposit(-20));
    }

    @Test
    public void withdrawcorrect(){
        Account account = new Account(-20);

        account.deposit(50);
        assertEquals(true,account.withdraw(20));
    }


    @Test
    public void depositcorrect(){
        Account account = new Account(-20);


        assertEquals(true,account.deposit(50));
    }

    @Test
    public void checkallvalues(){
        Account account = new Account(-20);

        assertEquals(true,account.deposit(50));
        assertEquals(50d,account.getBalance(), epsilon);

        assertEquals(true,account.withdraw(20));
        assertEquals(30d,account.getBalance(), epsilon);
    }

}
