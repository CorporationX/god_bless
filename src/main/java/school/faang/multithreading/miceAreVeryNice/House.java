package school.faang.multithreading.miceAreVeryNice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private static final int THREAD_POOL_SIZE = 5;

    private final List<Room> roomList = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    private static CountDownLatch countDownLatch;

    public void collectFood() {
        Room firstRoom = roomList.get(new Random().nextInt(roomList.size()));
        Room secondRoom = roomList.get(new Random().nextInt(roomList.size()));

        collectFoodInRoom(firstRoom);
        collectFoodInRoom(secondRoom);
    }

    public static void main(String[] args) {
        Food chocolate = new Food("chocolate");
        Food avocado = new Food("avocado");
        Food cherry = new Food("cherry");
        Food cheese = new Food("cheese");
        Food potato = new Food("potato");

        Room room1 = new Room(new ArrayList<>(List.of(potato, chocolate)), 1);
        Room room2 = new Room(new ArrayList<>(List.of(chocolate, potato, cheese)), 2);
        Room room3 = new Room(new ArrayList<>(List.of(avocado, cherry)), 3);
        Room room4 = new Room(new ArrayList<>(List.of(cheese, potato, chocolate)), 4);
        Room room5 = new Room(new ArrayList<>(List.of(cheese, potato, chocolate)), 5);
        Room room6 = new Room(new ArrayList<>(List.of(potato, chocolate)), 6);
        Room room7 = new Room(new ArrayList<>(List.of(chocolate, potato, cheese)), 7);
        Room room8 = new Room(new ArrayList<>(List.of(avocado, cherry)), 8);
        Room room9 = new Room(new ArrayList<>(List.of(cheese, potato, chocolate)), 9);

        House house = new House();
        house.getRoomList().addAll(List.of(room1, room2, room3, room4, room5, room6, room7, room8, room9));
        countDownLatch = new CountDownLatch(house.getRoomList().size());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, 3, TimeUnit.SECONDS);
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
            System.out.println("Вся еда собрана");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void collectFoodInRoom(Room room) {
        synchronized (room) {
            if (room.hasFood()) {
                System.out.println("Собираем еду в комнате " + room.getNumber());
                collectedFood.addAll(room.collectFood());
                countDownLatch.countDown();
            }
        }
    }
}
