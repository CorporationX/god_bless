package school.faang.mice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREADS_COUNT = 5;
    private static final int TIME_PER_ROOM = 30;

    public static void main(String[] args) {
        House house = initHouse();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREADS_COUNT);
        executor.scheduleAtFixedRate(house::collectFood, 0, TIME_PER_ROOM, TimeUnit.SECONDS);
        long timeToFinish = (long) (house.getRooms().size() + 1) / 2 * TIME_PER_ROOM;
        executor.schedule(executor::shutdown, timeToFinish, TimeUnit.SECONDS);
        try {
            if (!executor.awaitTermination(timeToFinish + TIME_PER_ROOM, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        boolean isHouseClean = house.getRooms().stream().noneMatch(Room::hasFood);
        System.out.println(isHouseClean ? "House is clean" : "House is not clean");
    }

    private static House initHouse() {
        Food pizza = new Food("pizza");
        Food apple = new Food("apple");
        Food pineapple = new Food("pineapple");
        Food chips = new Food("chips");
        Food soda = new Food("soda");

        Room livingRoom = new Room("living room");
        livingRoom.addFood(pizza);
        livingRoom.addFood(apple);
        Room diningRoom = new Room("dining room");
        diningRoom.addFood(pineapple);
        diningRoom.addFood(chips);
        Room bedroom = new Room("bedroom");
        bedroom.addFood(soda);

        return new House(List.of(livingRoom, diningRoom, bedroom));
    }
}
