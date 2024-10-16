package Tom_Jerry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        Food apple = new Food("apple");
        Food orang = new Food("ogang");
        Food lime = new Food("lime");
        Food carrot = new Food("carrot");
        Food potate = new Food("potate");
        Food cabage = new Food("cabage");
        Food bread = new Food("bread");
        Food milk = new Food("milk");

        Room bedroom = new Room();
        bedroom.initialize(apple);
        bedroom.initialize(orang);

        Room dineroom = new Room();
        dineroom.initialize(lime);
        dineroom.initialize(carrot);
        dineroom.initialize(milk);

        Room kitchen = new Room();
        kitchen.initialize(potate);
        kitchen.initialize(cabage);
        kitchen.initialize(bread);

        Room bathroom = new Room();

        House house = new House();
        house.initializeHouse(bathroom);
        house.initializeHouse(bedroom);
        house.initializeHouse(kitchen);
        house.initializeHouse(dineroom);

        ScheduledExecutorService executorServicehed = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executorServicehed.scheduleAtFixedRate(() -> {
            house.collectFood();
            System.out.println("Tho rooms cleaned "+Thread.currentThread().getName());
        if (house.allFoodCollected()) {
            System.out.println("The house is clean");
            executorServicehed.shutdown();
            }
        },0, 10, TimeUnit.SECONDS);

}
}
