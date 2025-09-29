package school.faang.bjs2_93330;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Bank phoenixBank = new Bank();
        phoenixBank.getAccounts().put(1, new Account(1, 5_000));
        phoenixBank.getAccounts().put(2, new Account(2, 5_000));
        phoenixBank.getAccounts().put(3, new Account(3, 5_000));
        phoenixBank.getAccounts().put(4, new Account(4, 5_000));
        phoenixBank.getAccounts().put(5, new Account(5, 5_000));
        phoenixBank.getAccounts().put(6, new Account(6, 5_000));

        List<Thread> threads = List.of(
                new Thread(() -> phoenixBank.transfer(1, 2, 500)),
                new Thread(() -> phoenixBank.transfer(2, 3, 1_000)),
                new Thread(() -> phoenixBank.transfer(5, 6, 15_000)),
                new Thread(() -> phoenixBank.transfer(6, 1, 800)),
                new Thread(() -> phoenixBank.transfer(4, 2, 900)),
                new Thread(() -> phoenixBank.transfer(3, 5, 250)),
                new Thread(() -> phoenixBank.transfer(1, 4, 2_000)),
                new Thread(() -> log.info(String.valueOf(phoenixBank.getTotalBalance())))
        );
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
