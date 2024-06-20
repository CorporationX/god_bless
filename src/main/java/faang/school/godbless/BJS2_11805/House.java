package faang.school.godbless.BJS2_11805;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    // куда собираем еду из комнат
    public static final List<Food> food = new ArrayList<>();
    // список комнат
    public static final List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        // создаем комнаты
        for (int i = 1; i < 21; i++) {
            rooms.add(new Room("Room " + i));
        }

        // добавляем в комнату список еды
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);

            for (int j = 1; j < 31; j++) {
                room.addFood(new Food("Food " + (j + i*31)));
            }
        }

        System.out.println("Before collecting: " + food);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        rooms.forEach(room -> {
            executorService.schedule(room, (long)(Math.random() * 11 + 1), TimeUnit.SECONDS);
        });

        executorService.shutdown();

        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("All food is collected");
                break;
            }
        }

        System.out.println("After collecting: " + food);
    }
}
