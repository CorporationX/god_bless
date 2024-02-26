package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(() -> {
            Thread.sleep(10);
            return 100;
        });
        Future<Integer> future2 = executor.submit(() -> {
            Thread.sleep(5);
            return 2;
        });

        while (!future1.isDone() || !future2.isDone()) {
            System.out.println("Пока что сделаем тут что-нибудь важное...");
            System.out.println("Погода сегодня " + weatherToday());
        }

        int result1 = future1.get();
        int result2 = future2.get();

        System.out.println("Результат операции 1: " + result1);
        System.out.println("Результат операции 2: " + result2);

        executor.shutdown();
    }

    private static String weatherToday() {
        return " облачная";
    }
}