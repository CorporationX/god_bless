package BJS2_25265_PlayBank;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.getAccounts().put(1, new Account( 400.0));
        bank.getAccounts().put(2, new Account(250.0));
        bank.getAccounts().put(3, new Account(1000.0));
        bank.getAccounts().put(4, new Account(100_000));
        bank.getAccounts().put(5, new Account(43_520));
        bank.getAccounts().put(6, new Account(155.0));

        for (int i = 1; i < 6; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> bank.transfer(bank.getAccounts().get(finalI),
                    bank.getAccounts().get(finalI + 1),
                    Math.random() * 500));
            thread.start();
        }
    }
}
