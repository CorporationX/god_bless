package school.faang.BJS2_36163;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final Logger logger = LoggerFactory.getLogger(House.class);
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void collectFood(ScheduledExecutorService executorService) {
        if (rooms.size() < 2) {
            logger.info("Недостаточно комнат для сбора еды.");
            return;
        }

        List<Room> roomsWithFood = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isCollected()) {
                roomsWithFood.add(room);
            }
        }

        if (roomsWithFood.size() < 2) {
            executorService.shutdown();
            logger.info("Еда в доме собрана!");
            return;
        }

        Random random = new Random();
        int roomIndex1 = random.nextInt(roomsWithFood.size());
        int roomIndex2;
        do {
            roomIndex2 = random.nextInt(roomsWithFood.size());
        } while (roomIndex1 == roomIndex2);

        Room room1 = roomsWithFood.get(roomIndex1);
        Room room2 = roomsWithFood.get(roomIndex2);

        collectedFood.addAll(room1.getFood());
        collectedFood.addAll(room2.getFood());

        room1.markAsCollected();
        room2.markAsCollected();

        logger.info("Еда собрана из комнаты - {} и комнаты - {}", room1.getRoomNumber(), room2.getRoomNumber());
    }

    public static void main(String[] args) {
        House house = new House();

        for (int i = 1; i <= 10; i++) {
            Room room = new Room(i);
            for (int j = 1; j <= 5; j++) {
                room.addFood(new Food("Еда " + j + "в комнате - " + i));
            }
            house.addRoom(room);
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(() -> house.collectFood(executorService), 0, 5, TimeUnit.SECONDS);
        }
    }
}
