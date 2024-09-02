package faang.school.godbless.ThirdSprint.BJS2_23871;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class House {
    private Map<Integer, List<Room>> roommap = new HashMap<>();
    private List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.initialize();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            service.schedule(() -> {
                System.out.println(Thread.currentThread().getName());
                house.roommap.get(finalI).stream().forEach(r -> house.collectFood(r));
            }, 5 * (i + 1), TimeUnit.SECONDS);
        }

        service.shutdown();
        while(!service.awaitTermination(30, TimeUnit.SECONDS)){}

        System.out.println(house.roommap);
        System.out.println(house.collectedFood);
    }

    public void initialize() {
        for (int i = 0; i < 5; i++){
            roommap.computeIfAbsent(i, (a) -> new ArrayList<>()).add(new Room());
            roommap.get(i).add(new Room());
        }
        Food[] foods = new Food[]{new Food("cheese"),
                new Food("meet"),
                new Food("milk"),
                new Food("bread"),
                new Food("apple")};
        for (int i = 0; i < 5; i++) {
            roommap.get(i).stream()
                    .forEach(u -> u.getFoodList()
                            .add(foods[ThreadLocalRandom.current().nextInt(0, 4)]));
        }
    }

    public void collectFood(Room room) {
        synchronized (collectedFood) {
            collectedFood.addAll(room.getFoodList());
            room.getFoodList().clear();
        }
    }
}