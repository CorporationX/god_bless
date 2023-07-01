package faang.school.godbless.multithreading.mice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        House house = new House();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < house.getRooms().size() / 2; i++) {
            executor.schedule(house::collectFood, i * 2, TimeUnit.SECONDS);
        }
        executor.shutdown();

        if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Вся еда в доме собрана!");
        }

    }
}
