package school.faang.mice;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class House {
    private static final Room ABSENT_ROOM = new Room(-1, Collections.emptyList());
    private final List<Room> rooms;
    private final AtomicInteger roomsCounter = new AtomicInteger();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Object lock = new Object();
    private boolean isClear = false;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        Collections.shuffle(rooms);
    }

    private boolean hasNextRoom() {
        return roomsCounter.get() < rooms.size();
    }

    private synchronized Room gettingRoom() {
        try {
            if (hasNextRoom()) {
                log.info("Назначена для уборки комната из списка под индексом {}", roomsCounter.get());
                return rooms.get(roomsCounter.getAndIncrement());
            }
            log.info("Грязных комнат больше нет");
            this.isClear = true;
            return ABSENT_ROOM;
        } finally {
            if (!hasNextRoom()) {
                this.isClear = true;
                log.info("меняем флаг состояния дома на {}", this.isClear);
            }
        }
    }

    public void collectFood() {
        Room roomOne = gettingRoom();
        Room roomTwo = gettingRoom();
        log.info("Рандомно выбрали комнаты №№ [{} и {}]", roomOne.getRoomNumber(), roomTwo.getRoomNumber());

        synchronized (lock) {
            collectedFood.addAll(roomOne.clearRoom());
            log.info("Собрали еду из комнаты № {}", roomOne.getRoomNumber());
        }
        synchronized (lock) {
            collectedFood.addAll(roomTwo.clearRoom());
            log.info("Собрали еду из комнаты № {}", roomTwo.getRoomNumber());
        }
    }
}