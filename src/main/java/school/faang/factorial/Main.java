package school.faang.factorial;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 10, 15, 20, 25, 30);
        var futures = Factorial.calculateFactorials(numbers);
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> futures.forEach(future -> System.out.println(future.join())))
                .join();
    }
}
