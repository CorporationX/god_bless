package school.faang.BJS236005;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private boolean allFoodCollected = false;
    private List<Food> collectedFood = new ArrayList<>();
    private Random random = new Random();


    public void init() {
        rooms.add(new Room("Спальня", List.of("Сыр", "Колбаса")));
        rooms.add(new Room("Гостевая", List.of("Орешек", "Сахарок")));
        rooms.add(new Room("Кухня", List.of("Мясо", "Маслины")));
        rooms.add(new Room("Ванная", List.of("Леденец")));
        rooms.add(new Room("Гардероб", List.of("Чипса", "Сыр", "Кабачок")));
        rooms.add(new Room("Чердак", List.of("Огурцы", "Помидоры")));
    }

    public void collectFood() {
        Room roomOne = rooms.get(getRandomNumber(0, rooms.size() / 2 - 1));
        Room roomTwo = rooms.get(getRandomNumber(rooms.size() / 2, rooms.size() - 1));
        if (!roomOne.getFoods().isEmpty() && !roomTwo.getFoods().isEmpty()) {
            collectedFood.addAll(roomOne.getFoods());
            collectedFood.addAll(roomTwo.getFoods());

            roomOne.setFoods(new ArrayList<>());
            roomTwo.setFoods(new ArrayList<>());
        }
    }

    private int getRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
