package faang.school.godbless.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static BigInteger factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        int result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return BigInteger.valueOf(result);
    }

    static BigInteger factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        long result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return BigInteger.valueOf(result);
    }

    static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return factorialLong(n);
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers){
        List<CompletableFuture<BigInteger>> futures = new ArrayList<>();
        numbers.stream().collect(Collectors.groupingBy(Factorial::groupNumbers))
                .forEach((key, value) -> {
                    switch (key) {
                        case "int" ->
                                value.forEach(number -> futures.add(CompletableFuture.supplyAsync(() -> factorialInt(number))));
                        case "long" ->
                                value.forEach(number -> futures.add(CompletableFuture.supplyAsync(() -> factorialLong(number))));
                        case "big" ->
                                value.forEach(number -> futures.add(CompletableFuture.supplyAsync(() -> factorialBig(number))));
                    }
                });
        return futures;
    }
    private static String groupNumbers(int number){
        if(number <= MAX_INT_FACTORIAL){
            return "int";
        }
        else if(number <= MAX_LONG_FACTORIAL){
            return "long";
        }
        else {
            return "big";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < result.size(); ++i) {
            final int a = i;
            new Thread(
                    () -> {
                        result.get(a).join();
                        counter.incrementAndGet();
                    }
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);

    }
}
