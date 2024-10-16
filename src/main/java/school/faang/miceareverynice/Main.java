package school.faang.miceareverynice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        House house = new House();

        Room firstRoom = new Room();
        Room secondRoom = new Room();
        Room thirdRoom = new Room();

        Food cheese = new Food("Cheese");
        Food apple = new Food("Apple");
        Food banana = new Food("Banana");

        firstRoom.addFood(cheese);
        firstRoom.addFood(apple);
        firstRoom.addFood(banana);

        secondRoom.addFood(cheese);
        secondRoom.addFood(apple);
        secondRoom.addFood(banana);

        thirdRoom.addFood(cheese);
        thirdRoom.addFood(apple);
        thirdRoom.addFood(banana);

        house.addRoom(firstRoom);
        house.addRoom(secondRoom);
        house.addRoom(thirdRoom);

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            pool.scheduleAtFixedRate(() -> {
                house.collectFood();
                System.out.println(Thread.currentThread().getName() + "Собрали еду. Текущий список собранной еды : " + house.getCollectedFoods());
            }, 0, 30, TimeUnit.SECONDS);
        }

        pool.schedule(() -> {
            pool.shutdown();
            System.out.println("Еда в доме собрана!");
        }, 2, TimeUnit.MINUTES);

    }
}
