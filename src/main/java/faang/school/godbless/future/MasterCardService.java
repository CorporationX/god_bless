package faang.school.godbless.future;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final Random random = new Random();

    @SneakyThrows
    public int collectPayment() {
        Thread.sleep(100);
        return random.nextInt(100);
    }

    @SneakyThrows
    public int sendAnalytics() {
        Thread.sleep(100);
        return random.nextInt(100);
    }


}
