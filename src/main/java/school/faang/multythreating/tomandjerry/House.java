package school.faang.multythreating.tomandjerry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    public static final int THREAD_AMOUNT = 5;

    private final List<Room> roomsList;
    private final List<Food> allFood = new ArrayList<>();

    public static void main(String[] args) {
        House house = new House(Arrays.asList(
                new Room(Arrays.asList(new Food("potato"), new Food("tomato"))),
                new Room(Arrays.asList(new Food("cucumber"), new Food("cheese"))),
                new Room(Arrays.asList(new Food("fish"), new Food("bread"))),
                new Room(Arrays.asList(new Food("milk"), new Food("butter"))),
                new Room(Arrays.asList(new Food("onion"), new Food("meat"))),
                new Room(Arrays.asList(new Food("oil"), new Food("salt"))),
                new Room(Arrays.asList(new Food("soup"), new Food("tea"))),
                new Room(Arrays.asList(new Food("coffee"), new Food("sugar"))),
                new Room(Arrays.asList(new Food("paper"), new Food("cookie"))),
                new Room(Arrays.asList(new Food("chocolate"), new Food("cake")))
        ));
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_AMOUNT);

        for(int i = 0; i < THREAD_AMOUNT; i++) {
            executorService.scheduleAtFixedRate(() -> house.collectFood(executorService), 0, 2, TimeUnit.SECONDS);
        }
    }

    public House(List<Room> roomsList) {
        this.roomsList = roomsList;
    }

    public void collectFood(ScheduledExecutorService executorService) {
        if (roomsList.stream().allMatch(room -> room.getFoodList().isEmpty())) {
            executorService.shutdown();
            System.out.println("Amount of food: " + allFood.size());
            System.out.println("The food in the house is collected");

            return;
        }

        Room firstRoom = getRandomRoom(roomsList);
        Room secondRoom = getRandomRoom(roomsList);

        if(!firstRoom.getFoodList().isEmpty()) {
            addFood(firstRoom);
        }

        if(!secondRoom.getFoodList().isEmpty()) {
            addFood(secondRoom);
        }
    }

    private void addFood (Room room) {
        synchronized (allFood) {
            allFood.addAll(room.getFoodList());
            room.clearFoodList();
        }
    }

    private Room getRandomRoom(List<Room> roomsList) {
        int index = (int) (Math.random() * roomsList.size());

        return roomsList.get(index);
    }
}
