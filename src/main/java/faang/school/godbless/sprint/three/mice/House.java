package faang.school.godbless.sprint.three.mice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<List<Room>> roomPairs = new ArrayList<>();
    private List<Food> foods = new CopyOnWriteArrayList<>();
    private final Object lockFood = new Object();

    public void initialize() {
        Food fish = new Food("Fish", 2);
        Food apple = new Food("Apple", 4);
        Food salad = new Food("Salad", 3);
        Food pasta = new Food("Pasta", 2);
        Food banana = new Food("Banana", 5);
        Food bacon = new Food("Bacon", 5);
        Food cheese = new Food("Cheese", 1);
        Food milk = new Food("Milk", 1);
        Food bread = new Food("Bread", 2);
        Food tomato = new Food("Tomato", 2);
        Food sweet = new Food("Sweet", 2);
        Food mushroom = new Food("Mushroom", 2);
        Food honey = new Food("Honey", 2);

        Room livingRoom = new Room("Living Room", new CopyOnWriteArrayList<>(List.of(fish, apple, salad, pasta, banana)));
        Room kitchen = new Room("Living Room", new CopyOnWriteArrayList<>(List.of(bacon, cheese, milk, bread)));
        Room livingRoom1 = new Room("Living Room 1", new CopyOnWriteArrayList<>(List.of(tomato, sweet)));
        Room livingRoom2 = new Room("Living Room 2", new CopyOnWriteArrayList<>(List.of(mushroom, honey)));

        addRoom(livingRoom);
        addRoom(kitchen);
        addRoom(livingRoom1);
        addRoom(livingRoom2);
        createRoomPairs();
    }

    public void collectFood(Room room) {
        this.addFood(this.getRandomFoodFromRoom(room));
    }

    public boolean noFoodInRooms() {
        return roomPairs.stream().flatMap(List::stream)
                .allMatch(room -> room.getFoods().isEmpty());
    }

    private void addRoom(Room room) {
        rooms.add(room);
    }

    private void addFood(Food food) {
        System.out.printf("Add the food: '%s' to house%n%n", food.getName());
        foods.add(food);
    }

    private void createRoomPairs() {
        for (int i = 0; i < rooms.size(); i += 2) {
            List<Room> pair = new ArrayList<>();
            pair.add(rooms.get(i));
            if (i + 1 < rooms.size()) {
                pair.add(rooms.get(i + 1));
            }
            roomPairs.add(pair);
        }
    }

    private Food getRandomFoodFromRoom(Room room) {
        synchronized (lockFood) {
            Random random = new Random();
            int randomIndex = random.nextInt(room.getFoods().size());
            Food food = room.getFoods().get(randomIndex);
            room.getFoods().remove(randomIndex);
            return food;
        }
    }
}
