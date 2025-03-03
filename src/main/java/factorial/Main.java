package factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 12, 20, 25, 0);

        List<CompletableFuture<BigInteger>> futures = Factorial.factorials(numbers);

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    for (int i = 0; i < numbers.size(); i++) {
                        int n = numbers.get(i);
                        futures.get(i).thenAccept(result ->
                                System.out.printf("Factorial %d = %d%n", n, result)
                        );
                    }
                    System.out.println("All calculations are complete!");
                })
                .join();
    }
}

