package tom_Jerry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        Food apple = new Food("apple");
        Food orang = new Food("ogang");
        Food lime = new Food("lime");
        Food carrot = new Food("carrot");
        Food potate = new Food("potate");
        Food cabage = new Food("cabage");
        Food bread = new Food("bread");
        Food milk = new Food("milk");

        Room bedroom = new Room();
        bedroom.addFood(apple);
        bedroom.addFood(orang);

        Room dineroom = new Room();
        dineroom.addFood(lime);
        dineroom.addFood(carrot);
        dineroom.addFood(milk);

        Room kitchen = new Room();
        kitchen.addFood(potate);
        kitchen.addFood(cabage);
        kitchen.addFood(bread);

        Room bathroom = new Room();

        House house = new House();
        house.addRoom(bathroom);
        house.addRoom(bedroom);
        house.addRoom(kitchen);
        house.addRoom(dineroom);

        ScheduledExecutorService executorServicehed = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executorServicehed.scheduleAtFixedRate(() -> {
            house.collectFood();
            System.out.println(Thread.currentThread().getName());
        }, 0, 5, TimeUnit.SECONDS);
        while (true) {
            if (house.allFoodCollected()) {
                System.out.println("Food in the house has been collected");
                executorServicehed.shutdown();
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Tasks not completed");
        }
    }
}
