package faang.school.godbless.BJS2_25580;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        MilitaryBase base1 = new MilitaryBase();
        MilitaryBase base2 = new MilitaryBase();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(base1);
        executor.execute(base2);

        IntStream.rangeClosed(1, 100).forEach(i ->
                executor.execute(() -> MilitaryBase.sendMessage("Hello " + i)));

        Thread.sleep(10_000L);
        base1.stop();
        base2.stop();

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
