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

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.initialize();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            service.schedule(() -> {
                System.out.println(Thread.currentThread().getName());
                house.collectFood();
            },5, TimeUnit.SECONDS);
        }

        service.shutdown();
        while(!service.awaitTermination(10, TimeUnit.SECONDS)){}

        System.out.println(house.roomList);
        System.out.println(house.collectedFood);
        System.out.println("Done");
    }

    public void initialize() {
        for (int i = 0; i < 5; i++){
        roomList.add(new Room());
        roomList.add(new Room());
        }
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

    public synchronized void collectFood() {
            roomList.stream()
                    .sorted((a, b) -> b.getFoodList().size() - a.getFoodList().size())
                    .limit(2)
                    .forEach(u -> {
                        collectedFood.addAll(u.getFoodList());
                        u.getFoodList().clear();
                    });
    }
}