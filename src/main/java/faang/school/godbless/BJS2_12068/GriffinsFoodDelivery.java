package faang.school.godbless.BJS2_12068;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for(String name: characterNames){
            service.submit(()-> new FoodDeliveryTask(name , new Random().nextInt(50)).run());
            if (name.equals(characterNames[characterNames.length-1])){
                service.shutdown();
            }
        }
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
            if(service.isShutdown()){
                System.out.println("Delivery to all participants has been accomplished");
            }
        }catch (InterruptedException exception){
            exception.getStackTrace();
        }

    }
}
