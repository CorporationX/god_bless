package faang.school.godbless.BJS2_24181;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int VLADS_COUNT = 2;
    private static final int THREAD_POOL_SIZE = 6;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        List<TamagotchiVlad> vlads = initVlads();
        VladController vladController = new VladController(vlads);

        EXECUTOR.execute(() -> {
            vladController.sleepAll();
            vladController.cleanAll();
        });

        EXECUTOR.execute(() -> vladController.removeVlad(vlads.get(0)));

        EXECUTOR.execute(() -> {
            vladController.feedAll();
            vladController.playAll();
        });

        EXECUTOR.shutdown();

        try {
            if (EXECUTOR.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Playing with tamagotchi finished!");
            } else {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    private static List<TamagotchiVlad> initVlads() {
        return IntStream.rangeClosed(1, VLADS_COUNT)
                .mapToObj(TamagotchiVlad::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
