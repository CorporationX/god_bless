package school.faang.bjs2_93337;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        Account accountOne = new Account(1, 50);
        Account accountTwo = new Account(2, 7000);
        Account accountThree = new Account(3, 200);
        Bank bank = new Bank(Map.of(1, accountOne, 2, accountTwo, 3, accountThree));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        Random random = new Random();
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            executor.submit(() -> {
                int from = random.nextInt(3) + 1;
                int to = random.nextInt(3) + 1;
                double amount = Math.round(random.nextDouble(bank.getAccounts().get(from).getBalance()) * 100) / 100;
                log.info("Thread: {}, From: {}, To: {}, Amount: {}", threadNum, from, to, amount);
                if (bank.transfer(from, to, amount)) {
                    System.out.println("Transfer done");
                    log.info("Transfer done");
                } else {
                    System.out.println("Error transfer");
                    log.error("Error transfer");
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.SECONDS);

        System.out.printf("Total balance: %s%n", bank.getTotalBalance());
        for (Map.Entry<Integer, Account> account : bank.getAccounts().entrySet()) {
            System.out.printf("Account: %s, Balance: %s%n", account.getKey(), account.getValue().getBalance());
        }
    }
}
