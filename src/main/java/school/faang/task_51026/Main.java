package school.faang.task_51026;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50000);
        Bank bank = new Bank();

        for (int i = 0; i < 2; i++) {
            bank.addAccount();
        }
        List<Future> tasks = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Account account1 = bank.getAccounts().values().stream()
                    .findAny()
                    .orElse(null);

            Account account2 = bank.getAccounts().values().stream()
                    .filter(a -> a != account1)
                    .findAny()
                    .orElse(null);

            tasks.add(executorService.submit(() ->
                    bank.transfer(account1, account2, Math.random() * 100)));
        }

        tasks.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Задачи выполнены");
    }
}
