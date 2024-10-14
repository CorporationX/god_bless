package bjs2_35735;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final int TOTAL_THREADS = 5;

    private List<Room> rooms;
    private List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Food> firstRoomFood = new ArrayList<>() {
            {
                new Food("Nachos");
                new Food("Cookies");
            }
        };

        List<Food> secondRoomFood = new ArrayList<>() {
            {
                new Food("Bread");
                new Food("Meatballs");
            }
        };

        List<Food> thirdRoomFood = new ArrayList<>() {
            {
                new Food("Rice");
                new Food("Chicken");
                new Food("Broccoli");
            }
        };

        List<Room> rooms = Arrays.asList(
                new Room(firstRoomFood),
                new Room(secondRoomFood),
                new Room(thirdRoomFood)
        );

        House house = new House(rooms);
        int roomAmountToSelect = 2;

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(TOTAL_THREADS);
        executorService.scheduleAtFixedRate(() -> house.collectFood(roomAmountToSelect),
                0, 30, TimeUnit.SECONDS);
        Thread.sleep(120000);
        executorService.shutdown();
    }

    public void collectFood(int roomAmountToSelect) {
        Set<Room> selectedRooms = selectRandomRooms(roomAmountToSelect);
        selectedRooms.forEach(room -> {
            List<Food> food = room.removeFoodFromRoom();
            addFoodToCollectedFoods(food);
        });
        System.out.println("All the food has been collected!");
    }

    public Set<Room> selectRandomRooms(int roomAmountToSelect) {

        if (roomAmountToSelect < 0) {
            System.out.println("Selected negative amount of rooms. Returning empty set");
            return new HashSet<>();
        }

        if (roomAmountToSelect > rooms.size()) {
            System.out.println("Selected more rooms than available. Returning all the rooms");
            return new HashSet<>(rooms);
        }

        Random random = new Random();
        Set<Room> selectedRooms = new HashSet<>();

        while (roomAmountToSelect != 0) {
            int roomNumber = random.nextInt(0, rooms.size());
            Room selectedRoom = rooms.get(roomNumber);

            if (!selectedRooms.contains(selectedRoom)) {
                selectedRooms.add(selectedRoom);
                roomAmountToSelect--;
            }
        }
        return selectedRooms;
    }

    public void addFoodToCollectedFoods(List<Food> food) {
        collectedFood.addAll(food);
    }
}
