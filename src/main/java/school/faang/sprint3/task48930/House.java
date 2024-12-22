package school.faang.sprint3.task48930;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import school.faang.sprint3.task48930.model.Food;
import school.faang.sprint3.task48930.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class House {
    private static final int MAX_THREAD_POOL_SIZE = 5;
    private static final int TIME_DELAY_SEC = 10;
    private static final int INIT_TIME_DELAY_SEC = 0;
    @Getter
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    @Getter
    private AtomicBoolean isHouseEmpty = new AtomicBoolean(false);

    public static void main(String[] args) {
        House house = fillHouse();
        house.collectFood();
    }

    public synchronized void addFood(List<Food> addedFood) {
        this.collectedFood.addAll(addedFood);
    }

    public void collectFood() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(MAX_THREAD_POOL_SIZE);
        for (int i = 0; i < MAX_THREAD_POOL_SIZE; i++) {
            FoodCollector officiant = new FoodCollector("Официант " + i, this);
            executor.scheduleWithFixedDelay(officiant, INIT_TIME_DELAY_SEC, TIME_DELAY_SEC, TimeUnit.SECONDS);
        }

        while (!this.isHouseEmpty.get()) {
            try {
                Thread.sleep(TIME_DELAY_SEC * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();  // Останавливаем прием новых задач
        log.info("Вся еда в доме собрана!");
        log.info("Вот что официантам удалось собрать:");
        log.info(collectedFood.toString());

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public void collectFoodInRooms(String collectorName, Room room1, Room room2) {
        collectFoodInRoom(collectorName, room1);
        collectFoodInRoom(collectorName, room2);
    }

    public void refreshIsEmpty() {
        for (Room room : rooms) {
            if (!room.isRoomEmpty()) {
                isHouseEmpty.set(false);
                return;
            }
            isHouseEmpty.set(true);
        }
    }

    private void collectFoodInRoom(String collectorName, Room room) {
        room.lock();
        if (!room.isRoomEmpty()) {
            List<Food> roomFood = room.getFoodList();
            this.addFood(roomFood);
            int foodQty = roomFood.size();
            log.info("{} собрал в комнате {} {} единиц еды.:{}", collectorName, room.getName(), foodQty, roomFood);
            room.clearFood();
        } else {
            log.info("{} пришел в комнату {}, но там еда уже собрана.", collectorName, room.getName());
        }
        room.unlock();
    }

    private static House fillHouse() {
        List<Food> roomFoodList1 = new ArrayList<>();
        roomFoodList1.add(new Food("Пиво"));
        roomFoodList1.add(new Food("Чипсы"));
        roomFoodList1.add(new Food("Колбаса"));

        List<Food> roomFoodList2 = new ArrayList<>();
        roomFoodList2.add(new Food("Молоко"));
        roomFoodList2.add(new Food("Яйца"));
        roomFoodList2.add(new Food("Мясо"));

        List<Food> roomFoodList3 = new ArrayList<>();
        roomFoodList3.add(new Food("Вода"));
        roomFoodList3.add(new Food("Шампанское"));
        roomFoodList3.add(new Food("Фрукты"));

        List<Food> roomFoodList4 = new ArrayList<>();
        roomFoodList4.add(new Food("Йогурт"));
        roomFoodList4.add(new Food("Кефир"));
        roomFoodList4.add(new Food("Ананас"));

        List<Food> roomFoodList5 = new ArrayList<>();
        roomFoodList5.add(new Food("Лимонад"));
        roomFoodList5.add(new Food("Печенье"));
        roomFoodList5.add(new Food("Мармелад"));

        House house = new House();
        house.rooms.add(new Room("Big room", new ArrayList<>(roomFoodList1)));
        house.rooms.add(new Room("Kitchen", new ArrayList<>(roomFoodList2)));
        house.rooms.add(new Room("Guest room", new ArrayList<>(roomFoodList3)));
        house.rooms.add(new Room("Bedroom", new ArrayList<>(roomFoodList4)));
        house.rooms.add(new Room("Bath", new ArrayList<>(roomFoodList5)));

        return house;
    }


}
