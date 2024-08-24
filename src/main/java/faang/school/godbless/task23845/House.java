package faang.school.godbless.task23845;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class House {
    private static List<Room> roomList = new ArrayList<>();
    private static List<Food> foodList = new ArrayList<>();

    public void collectFood(){

    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.schedule(() -> );
        }

    }
}
