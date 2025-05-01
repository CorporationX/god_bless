package school.faang.factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

import static school.faang.factorial.ThreadPoolProvider.executor;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<CompletableFuture<BigInteger>> factorialsFutures = Factorial.factorials(List.of(20, 100, 200, 300, 10));
        CountDownLatch counter = new CountDownLatch(factorialsFutures.size());

        log.debug("Current val of counter = {}", counter.getCount());
        for (CompletableFuture<BigInteger> factorialsFuture : factorialsFutures) {
            /* здесь делаю задачу в отдельном потоке по заданию, хотя по сути смысла в этом как будто не очень много,
            если мы потом все равно ждем, пока отработают все потоки.*/
            CompletableFuture.supplyAsync(factorialsFuture::join, executor)
                    .thenAccept(result -> {
                        counter.countDown();
                        System.out.println(result);
                    });
        }

        while (counter.getCount() > 0) {
            Thread.sleep(500);
        }
        log.debug("All tasks completed, counter = {}", counter.getCount());
        ThreadPoolProvider.gracefullyShutdown();
    }
}
