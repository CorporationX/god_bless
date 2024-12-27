package school.faang.sprint_4.task_50230;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = IntStream.range(1, 20)
                .boxed()
                .toList();

        List<CompletableFuture<BigInteger>> completableFutures = Factorial.calculateFactorials(integers);

        completableFutures.stream()
                .map(CompletableFuture::join)
                .forEach(System.out::println);
    }
}
