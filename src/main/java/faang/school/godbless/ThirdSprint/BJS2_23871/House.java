package faang.school.godbless.ThirdSprint.BJS2_23871;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class House {
    private List<Room> roomList = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            service.scheduleAtFixedRate(() -> {
                System.out.println(Thread.currentThread().getName());
                house.collectFood();
            }, 0, 30, TimeUnit.SECONDS);
        }

        while (house.roomList.stream().flatMap(r -> r.getFoodList().stream()).toList().size() > 0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        service.shutdown();

        System.out.println(house.roomList);
        System.out.println(house.collectedFood);
    }

    public void initialize() {
        roomList.add(new Room());
        roomList.add(new Room());
        Food[] foods = new Food[]{new Food("cheese"),
                new Food("meet"),
                new Food("milk"),
                new Food("bread"),
                new Food("apple")};
        for (int i = 0; i < 5; i++) {
            roomList.stream()
                    .forEach(u -> u.getFoodList()
                            .add(foods[ThreadLocalRandom.current().nextInt(0, 4)]));
        }
    }

    public void collectFood() {
        roomList.stream()
                .forEach(u -> {
                    u.getFoodList().stream()
                            .forEach(f -> collectedFood.add(f));
                    u.getFoodList().remove(0);
                });
    }
}
