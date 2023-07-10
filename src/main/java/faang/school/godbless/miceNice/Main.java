package faang.school.godbless.miceNice;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        int delay = 0;

        for (int i = 1; i < 7; i += 2) {
            Room room1 = house.getRooms().get(i);
            Room room2 = house.getRooms().get(i + 1);

            executor.schedule(() -> house.collectFoodFromTwoRooms(room1, room2), delay, TimeUnit.SECONDS);

            delay += 5;
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("Еда собрана");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
