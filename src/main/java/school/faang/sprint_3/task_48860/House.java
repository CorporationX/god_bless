package school.faang.sprint_3.task_48860;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    public static final int ROOMS_NUMBER = 6;
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        addRooms();
    }

    private void addRooms() {
        for (int i = 1; i <= ROOMS_NUMBER; i++) {
            rooms.add(new Room(i));
        }
    }

    public void collectFoods() {
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        if (room1.hasFood() && room2.hasFood()) {
            collectFoodFromRoom(room1);
            collectFoodFromRoom(room2);
        } else {
            if (!room1.hasFood()) {
                System.out.println("В комнате №" + room1.getRoomNumber() + " нет еды.");
            }
            if (!room2.hasFood()) {
                System.out.println("В комнате №" + room2.getRoomNumber() + " нет еды.");
            }
        }
    }

    private void collectFoodFromRoom(Room room) {
        collectedFood.addAll(room.getFoods());
        room.removeAllFood();
        System.out.println(Thread.currentThread().getName() + " cобрал еда из комнаты №" + room.getRoomNumber());
    }

    public boolean allFoodCollected() {
        return rooms.stream()
                .noneMatch(Room::hasFood);
    }
}
