package school.faang.stream4.becometwittercelebrity;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static final long
            VERY_IMPORTANT_CONSTANT_OF_DEFAULT_EXECUTOR_SHUTDOWN_TIME_THAT_DETERMINES_ALL_PROGRAM_BEHAVIOUR = 30L;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem(executorService);

        TwitterAccount celebrity = new TwitterAccount("Superstar", 500_000);

        List<TwitterAccount> newFollowers =
                IntStream.range(0, 1000_000).boxed()
                        .map(i -> new TwitterAccount("noname" + i, 1))
                        .toList();

        List<CompletableFuture<TwitterAccount>> completableFutures =
                newFollowers.stream()
                        .map(noname -> system.followAccount(noname, celebrity))
                        .toList();

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
                .join();

        System.out.println(celebrity.getFollowers());

        endExecutor(executorService);

    }

    public static void endExecutor(ExecutorService service) {
        service.shutdown();
        try {
            if (!service.awaitTermination(
                    VERY_IMPORTANT_CONSTANT_OF_DEFAULT_EXECUTOR_SHUTDOWN_TIME_THAT_DETERMINES_ALL_PROGRAM_BEHAVIOUR,
                    TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


}
