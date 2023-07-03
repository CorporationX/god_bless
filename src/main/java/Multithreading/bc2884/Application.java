package Multithreading.bc2884;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        List<VladController> vladControllers = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            vladControllers.add(new VladController());
        }
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (VladController controller : vladControllers){
            executorService.execute(() ->{
                controller.feedAll();
                controller.playAll();
                controller.cleanAll();
                controller.sleepAll();
            });
        }
        executorService.shutdown();

    }
}
