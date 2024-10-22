package school.faang.tamagotchi_vlad_BJS2_36725;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int AWAITING_TIME = 3;
        final int TAMAGOCHIES_QUANTITY = 7;

        VladController controller  = new VladController();

        for (int i = 0; i < TAMAGOCHIES_QUANTITY; i++) {
            controller.addTamagochi(new TamagochiVlad("Vlad " + i));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(controller::feedAllTamagochi);
        executorService.submit(controller::playAllTamagochi);
        executorService.submit(controller::cleanAllTamagochi);
        executorService.submit(() -> controller.deleteTamagochi(controller.getAllTamagochies().get(0)));
        executorService.submit(controller::sleepAllTamagochi);

        executorService.shutdown();

        if(executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)){
            System.out.println("All Tamagochi Vlad finished!");
        }else{
            System.out.println("Tamagochi Vlad failed to finish!");
        }
    }
}
