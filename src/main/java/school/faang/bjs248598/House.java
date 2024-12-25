package school.faang.bjs248598;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Getter
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    @Setter
    private CountDownLatch countDownLatch;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        createRooms();
    }

    private void createRooms() {
        for (int i = 0; i <= 8; i++) {
            rooms.add(new Room(1000 + i));
        }
    }

    public void collectFood() {
        List<Room> randomRoom = getTwoRandomRoom();
        for (Room room : randomRoom) {
            if (room.tryLock()) {
                if (!room.isClear()) {
                    getFoodFromRoom(room);
                    break;
                }
                room.unlock();
            }
        }
    }

    private List<Room> getTwoRandomRoom() {
        Random random = new Random();
        int firstIndex = random.nextInt(rooms.size());
        int secondIndex;

        do {
            secondIndex = random.nextInt(rooms.size());
        } while (secondIndex == firstIndex);
        List<Room> randomRooms = new ArrayList<>();
        randomRooms.add(rooms.get(firstIndex));
        randomRooms.add(rooms.get(secondIndex));
        return randomRooms;
    }

    private void getFoodFromRoom(Room room) {
        collectedFood.addAll(room.collectFood());
        System.out.println(Thread.currentThread().getName() + " has been collect in room " + room.getNumber());
        countDownLatch.countDown();
    }

    public int notCleanedUpRoom() {
        return rooms.size();
    }
}
