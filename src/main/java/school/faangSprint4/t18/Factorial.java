package school.faangSprint4.t18;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final int TIME_SLEEP = 100;
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 10, 15, 20, 25);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        ExecutorService monitorExecutor = Executors.newSingleThreadExecutor();

        try {
            List<CompletableFuture<BigInteger>> futures = factorials(numbers, executorService);
            AtomicInteger completedTasks = new AtomicInteger(0);

            MonitorTask monitorTask = new MonitorTask(completedTasks, futures.size());
            CompletableFuture<Void> monitorFuture = CompletableFuture.runAsync(monitorTask, monitorExecutor);

            List<CompletableFuture<Void>> processingFutures = new ArrayList<>();

            for (int i = 0; i < futures.size(); i++) {
                final int index = i;
                CompletableFuture<BigInteger> future = futures.get(i);

                CompletableFuture<Void> processingFuture = future
                        .thenAcceptAsync(result -> {
                            System.out.printf("Factorial of %d = %s%n", numbers.get(index), result);
                            completedTasks.incrementAndGet();
                        }, executorService)
                        .exceptionally(throwable -> {
                            System.out.printf("Error calculating factorial for %d: %s%n",
                                    numbers.get(index), throwable.getMessage());
                            completedTasks.incrementAndGet();
                            return null;
                        });

                processingFutures.add(processingFuture);
            }

            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                    processingFutures.toArray(new CompletableFuture[0])
            );

            allFutures
                    .thenRun(monitorTask::stop)
                    .thenCompose(v -> monitorFuture)
                    .orTimeout(5, TimeUnit.SECONDS)
                    .exceptionally(throwable -> {
                        System.out.println("Execution timed out or failed: " + throwable.getMessage());
                        return null;
                    })
                    .join();

        } catch (Exception e) {
            System.out.println("Error during execution: " + e.getMessage());
        } finally {
            executorService.shutdown();
            monitorExecutor.shutdown();
            try {
                if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
                if (!monitorExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
                    monitorExecutor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                monitorExecutor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Number is too large for int factorial. Use factorialLong or factorialBig");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Number is too large for long factorial. Use factorialBig");
        }
        long result = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers, ExecutorService executorService) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size(); i++) {
            int finalI = i;
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(
                    () -> factorialBig(numbers.get(finalI))
            );
            results.add(result);
        }
        return results;
    }

    static class MonitorTask implements Runnable {
        private final AtomicInteger completedTasks;
        private final int totalTasks;
        private volatile boolean running = true;

        public MonitorTask(AtomicInteger completedTasks, int totalTasks) {
            this.completedTasks = completedTasks;
            this.totalTasks = totalTasks;
        }

        public void stop() {
            this.running = false;
        }

        @Override
        public void run() {
            while (running && completedTasks.get() < totalTasks) {
                try {
                    Thread.sleep(TIME_SLEEP);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("All calculations completed!");
        }
    }
}