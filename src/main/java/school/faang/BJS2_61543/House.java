package school.faang.BJS2_61543;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class House {

    private static final int MAX_ROOM_AMOUNT = 15;
    private static final int ROOMS_TO_COLLECT_FOOD_COUNT = 2;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public synchronized void collectFood() {
        Set<Room> visitedRooms = new HashSet<>();
        for (int i = 0; i < ROOMS_TO_COLLECT_FOOD_COUNT; i++) {
            Room room;
            do {
                room = getRandomRoom();
            } while (visitedRooms.contains(room) && visitedRooms.size() < rooms.size());
            visitedRooms.add(room);
            System.out.println("Collecting food from room №%d".formatted(room.getRoomNumer()));
            collectedFood.addAll(room.clearFood());
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }

    private Room getRandomRoom() {
        int index = random.nextInt(rooms.size());

        return rooms.get(index);
    }

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }

    public void initializeHouse() {
        String[] foods = {"Pizza", "Sushi", "Burger", "Tacos", "Pasta", "Curry", "Fried Chicken", "Salad",
                "Steak", "Ramen", "Paella", "Dumplings", "Lasagna", "Butter", "Milk", "Biryani", "Sashimi",
                "Burrito", "Chow Mein", "Baklava"};

        IntStream.range(0, random.nextInt(5, MAX_ROOM_AMOUNT))
                .forEach(i -> this.addRoom(
                        new Room(i + 1) {{
                            IntStream.range(0, random.nextInt(5, 21))
                                    .forEach(j -> addFood(new Food(foods[random.nextInt(foods.length)])));
                        }}
                ));

        this.rooms.forEach(room -> {
            System.out.println("*****Room with food*****");
            room.printAllFood();
            System.out.println("");
        });
    }
}