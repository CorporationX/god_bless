package school.faang.tamagotchivlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        IntStream.range(0, 10)
                .mapToObj(i -> new TamagotchiVlad("Vlad" + (i + 1)))
                .forEach(controller::addTamagotchi);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Runnable[] tasks = {
                controller::feedAll,
                controller::playAll,
                controller::cleanAll,
                controller::sleepAll
        };

        for (Runnable task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
