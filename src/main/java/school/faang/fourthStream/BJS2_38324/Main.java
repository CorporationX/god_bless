package school.faang.fourthStream.BJS2_38324;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(50, 100, 200, 300, 400, 10, 25, 10000);

        List<CompletableFuture<BigInteger>> results = Factorial.factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < results.size(); ++i) {
            int index = i;
            new Thread(() -> {
                try {
                    BigInteger factorial = results.get(index).get();
                    System.out.println("Факториал числа " + numbers.get(index) + " = " + factorial);
                    counter.incrementAndGet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }

        System.out.println("Все асинхронные задачи завершены. Итераций ожидания: " + awaitCounter);
    }
}
