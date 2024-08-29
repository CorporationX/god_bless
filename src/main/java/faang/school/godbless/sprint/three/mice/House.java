package faang.school.godbless.sprint.three.mice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> foods = new CopyOnWriteArrayList<>();

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

        Room livingRoom = new Room("Living Room", new CopyOnWriteArrayList<>(List.of(fish, apple, salad, pasta, banana)));
        Room kitchen = new Room("Living Room", new CopyOnWriteArrayList<>(List.of(bacon, cheese, milk, bread)));

        addRoom(livingRoom);
        addRoom(kitchen);
    }

    public void collectFood() {
        rooms.forEach(room -> {
            this.addFood(this.getRandomFoodFromRoom(room));
        });
    }

    public boolean noFoodInRooms() {
        return rooms.stream()
                .anyMatch(room -> room.getFoods().isEmpty());
    }

    private void addRoom(Room room) {
        rooms.add(room);
    }

    private void addFood(Food food) {
        System.out.printf("Add the food: '%s' to house%n%n", food.getName());
        foods.add(food);
    }

    private Food getRandomFoodFromRoom(Room room) {
        Random random = new Random();
        int randomIndex = random.nextInt(room.getFoods().size());
        Food food = room.getFoods().get(randomIndex);
        room.getFoods().remove(randomIndex);
        return food;
    }
}
