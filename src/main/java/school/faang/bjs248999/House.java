package school.faang.bjs248999;

import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> foods;
    @Setter
    private CountDownLatch countDownLatch;

    public House() {
        this.foods = new ArrayList<>();
        this.rooms = new ArrayList<>();
        createRooms();
    }

    private void createRooms() {
        for (int i = 1; i < 9; i++) {
            int number = 100 + i;
            rooms.add(new Room(number));
            log.info("{} create room num: {}", Thread.currentThread().getName(), number);
        }
    }

    public void collectFood() {
        for (int i = 0; i < 2; i++) {
            for (Room room : rooms) {
                if (room.tryLock()) {
                    if (!room.isClear()) {
                        getFoodFromRoom(room);
                        break;
                    }
                }
                room.unLock();
            }
        }
    }

    private void getFoodFromRoom(@NonNull Room room) {
        foods.addAll(room.collectFood());
        log.info("{} get foods from room {}", Thread.currentThread().getName(), room.getNumber());
        countDownLatch.countDown();
    }

    public int numberRooms() {
        return rooms.size();
    }
}
