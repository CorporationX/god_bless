package faang.school.godbless.sprint_3.task_48727;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {

    private static final int NUMBER_OF_RANDOM_ROOMS = 2;

    private final Random random = new Random();

    private final List<Room> rooms = new ArrayList<>();

    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Комната не может быть null");
        }
        rooms.add(room);
    }

    public void collectFood() {
        for (int i = 0; i < NUMBER_OF_RANDOM_ROOMS; i++) {
            int randomIndex = random.nextInt(rooms.size());

            Room randomRoom = rooms.get(randomIndex);

            if (randomRoom.containsFood()) {
                collectedFood.addAll(randomRoom.getAllFood());
                randomRoom.removeAllFood();
            }
        }
    }

    public boolean isNoFoodInAllRooms() {
        for (Room room : rooms) {
            if (room.getAllFood().isEmpty()) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static House initHouse() {
        Room room1 = new Room();
        Food food1 = new Food("Cheese");
        Food food2 = new Food("Milk");
        room1.addFood(food1);
        room1.addFood(food2);

        Room room2 = new Room();
        Food food3 = new Food("Eggs");
        Food food4 = new Food("Bread");
        room2.addFood(food3);
        room2.addFood(food4);

        Room room3 = new Room();
        Food food5 = new Food("Cake");
        Food food6 = new Food("Sausage");
        room3.addFood(food5);
        room3.addFood(food6);

        Room room4 = new Room();
        Food food7 = new Food("Avocado");
        Food food8 = new Food("Beans");
        room4.addFood(food7);
        room4.addFood(food8);

        Room room5 = new Room();
        Food food9 = new Food("Potato");
        Food food10 = new Food("Apple");
        room5.addFood(food9);
        room5.addFood(food10);

        House house = new House();

        house.addRoom(room1);
        house.addRoom(room2);
        house.addRoom(room3);
        house.addRoom(room4);
        house.addRoom(room5);

        return house;
    }
}
