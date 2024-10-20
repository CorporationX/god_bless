package school.faang.veryNice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("Недостаточно комнат для сбора еды.");
            return;
        }

        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2;

        do {
            room2 = rooms.get(random.nextInt(rooms.size()));
        } while (room1 == room2);

        if (room1.hasFood()) {
            Food food = room1.getFoodList().get(0); // Берем первую еду
            room1.removeFood(food);
            collectedFood.add(food);
            System.out.println("Собрана еда: " + food.getName() + " из комнаты 1");
        }

        if (room2.hasFood()) {
            Food food = room2.getFoodList().get(0); // Берем первую еду
            room2.removeFood(food);
            collectedFood.add(food);
            System.out.println("Собрана еда: " + food.getName() + " из комнаты 2");
        }
    }

    public void showCollectedFood() {
        System.out.println("Собранная еда: ");
        for (Food food : collectedFood) {
            System.out.println(food.getName());
        }
    }
}
