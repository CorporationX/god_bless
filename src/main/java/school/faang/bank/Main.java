package school.faang.bank;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 1500);
        Account account3 = new Account(3, 2000);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        Runnable transferTask = () -> {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int fromAccountId = random.nextInt(3) + 1;
                int toAccountId = random.nextInt(3) + 1;
                while (fromAccountId == toAccountId) {
                    toAccountId = random.nextInt(3) + 1;
                }
                double amount = random.nextDouble() * 500;
                boolean success = bank.transfer(fromAccountId, toAccountId, amount);
                if (success) {
                    log.info("Перевод {} с аккаунта {} на аккаунт {} выполнен.", amount, fromAccountId, toAccountId);

                } else {
                    log.info("Перевод {} с аккаунта {} на аккаунт {}  отклонен.", amount, fromAccountId, toAccountId);
                }
            }
        };

        Thread thread1 = new Thread(transferTask);
        Thread thread2 = new Thread(transferTask);
        Thread thread3 = new Thread(transferTask);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Баланс банка : {} ", bank.getTotalBalance());
    }
}