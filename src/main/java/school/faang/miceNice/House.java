package school.faang.miceNice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        synchronized (this) {
            if (rooms.size() < 2) {
                System.out.println("Недостаточно комнат для сбора еды.");
                return;
            }

            Room room1 = rooms.get(random.nextInt(rooms.size()));
            Room room2 = rooms.get(random.nextInt(rooms.size()));
            System.out.println(Thread.currentThread().getName() + " собрал еду из комнат: " + room1.getName() + " и " + room2.getName());
            while (room1 == room2) {
                room2 = rooms.get(random.nextInt(rooms.size()));
            }

            collectedFood.addAll(room1.getFoodList());
            collectedFood.addAll(room2.getFoodList());
            rooms.remove(room1);
            rooms.remove(room2);
            room1.getFoodList().clear();
            room2.getFoodList().clear();
        }
    }
}
