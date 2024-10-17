package school.faang.tamagotchi_vlad_BJS2_36725;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int AWAITING_TIME = 3;

        VladController controller  = new VladController();
        controller.addTamagochi(new TamagochiVlad());
        controller.addTamagochi(new TamagochiVlad());
        controller.addTamagochi(new TamagochiVlad());
        controller.addTamagochi(new TamagochiVlad());

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(controller::feedAllTamagochi);
        executorService.submit(controller::playAllTamagochi);
        executorService.submit(() -> controller.addTamagochi(new TamagochiVlad()));
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
