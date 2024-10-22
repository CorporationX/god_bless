package miceAreVeryNice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        Room kitchen = new Room("Кухня");
        Room livingRoom = new Room("Гостиная");
        Room bedroom = new Room("Спальня");
        Room bathroom = new Room("Ванная");

        kitchen.addFood(new Food("Яблоко"));
        kitchen.addFood(new Food("Банан"));
        livingRoom.addFood(new Food("Конфета"));
        bedroom.addFood(new Food("Хлеб"));
        bathroom.addFood(new Food("Сыр"));

        house.addRoom(kitchen);
        house.addRoom(livingRoom);
        house.addRoom(bedroom);
        house.addRoom(bathroom);

        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(5);
        schedule.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        schedule.shutdown();
        System.out.println("Еда в доме собрана!");
    }
}
