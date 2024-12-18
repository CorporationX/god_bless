package school.faang.task_48243;

import lombok.Getter;
import lombok.Setter;
import school.faang.exception.CheckException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class House {
    @Getter
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    @Setter
    private CountDownLatch countDownLatch;

    public void addRoom(Room room) {
        if (room == null) {
            throw new CheckException("room");
        }

        rooms.add(room);
    }

    public void collectFood() {
        if (rooms.size() < 2) {
            throw new RuntimeException("Недостаточно комнат для сбора еды.");
        }

        Random random = new Random();
        int firstRoomIndex = random.nextInt(rooms.size());
        int secondRoomIndex;
        do {
            secondRoomIndex = random.nextInt(rooms.size());
        } while (secondRoomIndex == firstRoomIndex);

        Room firstRoom = rooms.get(firstRoomIndex);
        Room secondRoom = rooms.get(secondRoomIndex);
        if (!firstRoom.isEmpty()) {
            collectedFood.addAll(firstRoom.getFoodList());
            firstRoom.removeAllFood();
            countDownLatch.countDown();
        }
        if (!secondRoom.isEmpty()) {
            collectedFood.addAll(secondRoom.getFoodList());
            secondRoom.removeAllFood();
            countDownLatch.countDown();
        }
        System.out.println("Собрано еды: " + collectedFood.size());
    }
}
