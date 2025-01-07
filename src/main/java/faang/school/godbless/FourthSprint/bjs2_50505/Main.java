package faang.school.godbless.FourthSprint.bjs2_50505;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 7, 9, 11, 13, 17, 19, 23);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        AtomicInteger count = new AtomicInteger(0);
        List<CompletableFuture<BigInteger>> factorials = Factorial.factorials(numbers);
        for (int i = 0; i < factorials.size(); i++) {
            try {
                System.out.println("факториал чила " + numbers.get(i) + " равен " + factorials.get(count.get()).get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            count.incrementAndGet();
        }
        while (!executor.isTerminated()){
            try {
                executor.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
    }
}
