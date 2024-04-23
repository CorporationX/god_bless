package faang.school.godbless.TamagochiVlad;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREAD = 4;

    public static void main(String[] args) {
        List<TamagochiVlad> tamagochis = getTamagochi();
        VladController controller = new VladController(tamagochis);

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREAD);
        for (TamagochiVlad tamagochi : tamagochis) {
            pool.execute(() -> {
                controller.feedAll();
                System.out.println();
                controller.playAll();
                System.out.println();
            });
            pool.execute(() -> controller.removeTamagochi(tamagochi));
            pool.execute(() -> {
                controller.cleanAll();
                System.out.println();
                controller.sleepAll();
                System.out.println();
            });
        }
        pool.shutdown();

        try {
            while (!pool.awaitTermination(10, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<TamagochiVlad> getTamagochi() {
        List<TamagochiVlad> tamagochis = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> tamagochis.add(new TamagochiVlad(String.valueOf(i))));
        return tamagochis;
    }
}
