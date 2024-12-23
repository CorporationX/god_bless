package school.faang.sprint3.bjs_48206;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    private final int FOOD_TYPE_AMOUNT = 7;
    private final int roomsInHouse;

    private final List<Room> rooms;
    private final List<Food> collectedFood;
    private final List<String> foodTypes = new ArrayList<>();

    Random random = new Random();

    public House(int roomsInHouse) {
        this.roomsInHouse = roomsInHouse;
        collectedFood = new ArrayList<>();
        generateFoodTypes();
        rooms = new ArrayList<>();
        addRooms();
    }

    private void generateFoodTypes() {
        Faker faker = new Faker();
        for (int i = 0; i < FOOD_TYPE_AMOUNT * roomsInHouse; i++) {
            String foodType = faker.food().toString();
            foodTypes.add(foodType);
        }
    }

    private void addRooms() {
        for (int i = 0; i < roomsInHouse; i++) {
            int number = random.nextInt(100, 200);
            Room roomN = new Room(number);
            log.info("Added room {}", number);
            for (int j = 0; j < FOOD_TYPE_AMOUNT; j++) {
                String foodName = foodTypes.get(random.nextInt(foodTypes.size()));
                roomN.addFood(foodName);
            }
            rooms.add(roomN);
        }
    }

    public void collectFood() {
        int room1 = random.nextInt(rooms.size());
        Room firstRoom = rooms.get(room1);
        if (!firstRoom.isRoomCleaned()) {
            collectedFood.addAll(firstRoom.getFoodFromRoom());
            log.info("Food collected from room {}", firstRoom.getRoomNumber());
            firstRoom.cleanRoom();
        }

        int room2;
        do {
            room2 = random.nextInt(rooms.size());
        }
        while (room2 != room1);
        Room secondRoom = rooms.get(room1);
        if (!secondRoom.isRoomCleaned()) {
            collectedFood.addAll(secondRoom.getFoodFromRoom());
            log.info("Food collected from room {}", secondRoom.getRoomNumber());
            secondRoom.cleanRoom();
        }
    }

    public boolean allFoodCollected() {
        boolean workDone = true;
        for (Room room : rooms) {
            workDone &= room.isRoomCleaned();
        }
        return workDone;
    }
}
