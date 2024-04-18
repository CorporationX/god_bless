package faang.school.godbless.BJS25693;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TomAndJerryHouse {
    public static void main(String[] args) {
        House house = new House();

        Room room1 = new Room();
        room1.getFoods().add(new Food());
        room1.getFoods().add(new Food());

        Room room2 = new Room();
        room2.getFoods().add(new Food());
        room2.getFoods().add(new Food());

        house.getRooms().add(room1);
        house.getRooms().add(room2);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.schedule(house::collectFood, 10 * i, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Еда в доме собрана!");
    }
}
