package school.faang.tamagotchi;

import school.faang.ConcurrentUtils;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
public class Main {

    private static final int THREADS_NUM = 4;

    public static void main(String[] args) {
        var controller = new VladController();
        IntStream.range(0, 5)
                .forEach(i -> controller.addTamagotchi(new TamagotchiVlad("Vlad-%d".formatted(i))));
        var executor = Executors.newFixedThreadPool(THREADS_NUM);

        executor.execute(controller::playAll);
        executor.execute(controller::sleepAll);
        executor.execute(controller::feedAll);
        executor.execute(controller::cleanAll);

        ConcurrentUtils.shutdownExecutor(executor);
    }
}
