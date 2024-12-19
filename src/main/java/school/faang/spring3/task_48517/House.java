package school.faang.spring3.task_48517;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> allFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean allFoodCollected() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }

    public void collectFood() {
        int listSize = rooms.size();

        if (listSize < 2) {
            System.out.println("Список должен содержать как минимум два элемента.");
            return;
        }

        Random random = new Random();

        int randomRoom1 = random.nextInt(listSize);
        int randomRoom2;
        do {
            randomRoom2 = random.nextInt(listSize);
        } while (randomRoom2 == randomRoom1);

        Room one = rooms.get(randomRoom1);
        Room two = rooms.get(randomRoom2);

        getFood(one);
        getFood(two);
        System.out.println(Thread.currentThread().getName() + " no food");
    }

    private void getFood(Room room) {
        if (room.hasFood()) {
            allFood.addAll(room.getFoods());
            System.out.println(Thread.currentThread().getName() + " взял еду из комнаты " + room.getNumber());
            room.removeAllFood();
        }
    }


}
