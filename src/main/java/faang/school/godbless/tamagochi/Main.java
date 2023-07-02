package faang.school.godbless.tamagochi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        executorService.execute(controller::feedAll);
        executorService.execute(controller::playAll);
        executorService.execute(controller::cleanAll);
        executorService.execute(controller::sleepAll);
        executorService.execute(controller::addTamagotchi);
        executorService.execute(controller::deleteTamagotchi);

        executorService.shutdown();
    }
}
