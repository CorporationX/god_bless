package faang.school.godbless.mice_are_very_nice;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        House house = new House();
        Room room1 = new Room(List.of(new Food("apple"), new Food("cheese")));
        Room room2 = new Room(List.of(new Food("shawarma"), new Food("sandwich")));
        Room room3 = new Room(List.of(new Food("bread"), new Food("eag")));
        Room room4 = new Room(List.of(new Food("sausage"), new Food("pizza")));
        Room room5 = new Room(List.of(new Food("cola"), new Food("burger")));
        Room room6 = new Room(List.of(new Food("hot-dog"), new Food("ice-cream")));
        house.addRoom(room1);
        house.addRoom(room2);
        house.addRoom(room3);
        house.addRoom(room4);
        house.addRoom(room5);
        house.addRoom(room6);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for(int i = 0; i < house.getRooms().size()/2 + 1; i++) {
            executor.schedule(house :: collectFood, 3, TimeUnit.SECONDS);
        }
        executor.shutdown();

        while(!executor.awaitTermination(5, TimeUnit.SECONDS));
        System.out.println("Collected food: ");
        for(Food food : house.getFoods()) {
            System.out.print(food.getFoodName() + ", ");
        }
        System.out.println();
        System.out.println("\n" + "It's in the rooms now: ");
        System.out.println(house.getRooms());
    }
}
