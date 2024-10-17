package school.faang.miceAreVeryNice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static <ExecutorService> void main(String[] args) throws InterruptedException {
        Food bread = new Food("bread");
        Food meat = new Food("meat");
        Food cheese = new Food("cheese");
        Food banana = new Food("banana");
        Food apple = new Food("apple");
        Food vodka = new Food("vodka");
        Food cake = new Food("cake");

        List<Food> inTheFirstRoom = new ArrayList<>();
        inTheFirstRoom.add(bread);
        inTheFirstRoom.add(meat);
        inTheFirstRoom.add(cheese);
        Room firstRoom = new Room(inTheFirstRoom);

        List<Food> inTheSecondRoom = new ArrayList<>();
        inTheFirstRoom.add(meat);
        inTheFirstRoom.add(cheese);
        inTheFirstRoom.add(banana);
        Room secondRoom = new Room(inTheSecondRoom);

        List<Food> inTheThirdRoom = new ArrayList<>();
        inTheFirstRoom.add(cheese);
        inTheFirstRoom.add(banana);
        inTheFirstRoom.add(apple);
        Room thirdRoom = new Room(inTheThirdRoom);

        List<Food> inTheFourthRoom = new ArrayList<>();
        inTheFirstRoom.add(banana);
        inTheFirstRoom.add(apple);
        inTheFirstRoom.add(vodka);
        Room fourthRoom = new Room(inTheFourthRoom);

        List<Food> inTheFifthRoom = new ArrayList<>();
        inTheFirstRoom.add(apple);
        inTheFirstRoom.add(vodka);
        inTheFirstRoom.add(cake);
        Room fifthRoom = new Room(inTheFifthRoom);

        List<Room> roomsInDaHouse = new ArrayList<>();
        roomsInDaHouse.add(firstRoom);
        roomsInDaHouse.add(secondRoom);
        roomsInDaHouse.add(thirdRoom);
        roomsInDaHouse.add(fourthRoom);
        roomsInDaHouse.add(fifthRoom);
        House house = new House(roomsInDaHouse);

        ScheduledExecutorService executor =
                    Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(
                house::collectFood,0, 30, TimeUnit.SECONDS);

        executor.shutdown();
        boolean b = executor.awaitTermination(30, TimeUnit.SECONDS);
        if (b) {
            System.out.println("Еда в доме собрана!");
        }
    }

}
