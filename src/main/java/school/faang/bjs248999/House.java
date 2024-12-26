package school.faang.bjs248999;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> foods;
    private final CountDownLatch countDownLatch;
    private final int amountFood;

    public House(int amountFood, List<Room> rooms, CountDownLatch countDownLatch) {
        this.amountFood = amountFood;
        this.foods = new ArrayList<>();
        this.rooms = rooms;
        this.countDownLatch = countDownLatch;
    }


    public void collectFood() {
        for (int i = 0; i < amountFood; i++) {
            for (Room room : rooms) {
                try {
                    if (room.tryLock()) {
                        if (!room.isClear()) {
                            getFoodFromRoom(room);
                            break;
                        }
                    }
                } catch (Exception ex) {
                    log.info("Error! {}", String.valueOf(ex));

                } finally {
                    room.unLock();
                }
            }
        }
    }

    private void getFoodFromRoom(@NonNull Room room) {
        foods.addAll(room.collectFood());
        log.info("{} get foods from room {}", Thread.currentThread().getName(), room.getNumber());
        countDownLatch.countDown();
    }
}
