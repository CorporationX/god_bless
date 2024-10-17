package school.faang.miceverynice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Integer THREAD_POOL_SIZE = 5;
    private static final Integer ROOM_NUMBER = 2;

    public static void main(String[] args) {
        List<Food> collectedFood = new ArrayList<>();
        House house = new House();

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        threadPool.scheduleAtFixedRate(() -> {
            collectedFood.addAll(house.collectFood(ROOM_NUMBER));
            System.out.println("Собранная еда: " + collectedFood);
            if(Boolean.TRUE.equals(house.getIsProcessFinished())){
                threadPool.shutdown();
            }
        },0 ,30, TimeUnit.SECONDS);
    }
}
