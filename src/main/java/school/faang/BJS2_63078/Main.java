package school.faang.BJS2_63078;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> 40);
        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> 50);
        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> 60);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, Integer::sum)
                                                           .thenCombine(future3, Integer::sum)
                                                           .thenCombine(future4, Integer::sum)
                                                           .thenCombine(future5, Integer::sum)
                                                           .thenCombine(future6, Integer::sum);

        combinedFuture.thenAccept(result -> System.out.println("Сумма: " + result));
        try {
            int result = combinedFuture.get(); // Получаем результат
            System.out.println("Общий результат: " + result); // Выводим результат
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(); // Обработка возможных исключений
        }

    }
}




