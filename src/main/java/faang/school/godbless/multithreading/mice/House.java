package faang.school.godbless.multithreading.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import lombok.Getter;

@Getter
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        initialize();
    }

    public void collectFood() {
        rooms.stream()
                .filter(room -> !room.getFoodList().isEmpty())
                .limit(2)
                .forEach(this::collectInOneRoom);
    }

    private void collectInOneRoom(Room room) {
        collectedFood.addAll(room.getFoodList());
        System.out.println("Собрали " + room.getFoodList() + " в комнате " + room.getName());
        room.getFoodList().clear();
    }

    private void initialize() {
        rooms = IntStream.range(0, 10)
                .mapToObj(this::getNewRandomRoom)
                .toList();

        collectedFood = new ArrayList<>();
    }

    private Room getNewRandomRoom(int index) {
        String[] food = {"turkey", "ham", "milk", "cheese", "grape", "apple", "bread", "cupcake"};
        Random random = new Random();

        List<Food> foodList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(3, 11); i++) {
            foodList.add(new Food(food[random.nextInt(food.length)]));
        }

        return new Room("Room-" + (index + 1), foodList);
    }
}
