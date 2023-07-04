package faang.school.godbless.MiceAreVeryNice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Food> foods = List.of(new Food("Apple"), new Food("Meat"));
        List<Food> foods1 = List.of(new Food("Apple"), new Food("Meat"));
        House house = new House(List.of(new Room(foods), new Room(foods1)));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.schedule(house::collectFood, 1000, TimeUnit.MILLISECONDS);
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(house.getRooms().get(0).getFoods());
        System.out.println(house.getFoods());
        service.shutdown();
        System.out.println("Program is end");
    }
}
