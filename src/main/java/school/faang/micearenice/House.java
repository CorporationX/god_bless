package school.faang.micearenice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class House {

    private static final int THREAD_NUM = 5;
    private static final int DELAY_TIME = 0;
    private static final int PERIOD_TO_REPEAT = 30;
    private static final int TIME_OUT = 30;
    private static final int ROOMS_TO_COLLECT = 2;
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_NUM);

    public House() {
        this.rooms = initialise();
    }

    public static void main(String[] args) {
        House house = new House();
        house.startCollecting();
    }

    private synchronized void collectFood() {
        List<Room> roomsWithFood = rooms.stream().filter(Room::hasFood).toList();
        if (roomsWithFood.isEmpty()) {
            log.info("Комнат с едой не осталось");
            shutdownExecutor();
            return;
        }
        List<Room> selectedRooms = getRandomRooms(roomsWithFood);
        for (Room room : selectedRooms) {
            List<Food> food = room.collectFood();
            collectedFood.addAll(food);
            log.info("В комнате: {} собрано {} единиц еды", room.getName(), food.size());
        }
        log.info("Всего собрано {} единиц еды", collectedFood.size());
    }

    private void startCollecting() {
        executor.scheduleAtFixedRate(this::collectFood, DELAY_TIME, PERIOD_TO_REPEAT, TimeUnit.SECONDS);
    }

    private void shutdownExecutor() {
        log.info("Вся еда собрана! Общее количество составило {} единиц", collectedFood.size());
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private List<Room> getRandomRooms(List<Room> availableRooms) {
        if (availableRooms.size() < ROOMS_TO_COLLECT) {
            log.warn("Недостаточно комнат для уборки. Требуется {}, а в наличии {}",
                    ROOMS_TO_COLLECT, availableRooms.size());
            return availableRooms;
        }
        Set<Room> selectedRooms = new HashSet<>();
        while (selectedRooms.size() < ROOMS_TO_COLLECT) {
            Room room = availableRooms.get(random.nextInt(availableRooms.size()));
            selectedRooms.add(room);
            log.info("Уборка будет выполнена в комнате: {}", room.getName());
            selectedRooms.add(room);
        }
        return selectedRooms.stream().toList();
    }

    private List<Room> initialise() {

        Food apple = new Food("Apple");
        Food orange = new Food("Orange");
        Food lettuce = new Food("Lettuce");

        Room livingroom = new Room("гостиная");
        livingroom.addFood(apple);
        livingroom.addFood(orange);
        livingroom.addFood(lettuce);

        Food tomato = new Food("Tomato");
        Food potato = new Food("Potato");
        Food aubergine = new Food("Aubergine");

        Room bedroom = new Room("спальная");
        bedroom.addFood(tomato);
        bedroom.addFood(potato);
        bedroom.addFood(aubergine);

        Room kitchen = new Room("кухня");
        kitchen.addFood(apple);
        kitchen.addFood(tomato);
        kitchen.addFood(aubergine);

        Room toilet = new Room("туалет");
        toilet.addFood(potato);
        toilet.addFood(aubergine);
        toilet.addFood(apple);

        Room hall = new Room("коридор");
        hall.addFood(new Food("Bread"));
        hall.addFood(new Food("Milk"));
        hall.addFood(new Food("Cheese"));

        Room garage = new Room("гараж");
        garage.addFood(new Food("Cereal"));
        garage.addFood(new Food("Juice"));
        garage.addFood(new Food("Soda"));

        List<Room> rooms = new ArrayList<>();
        rooms.add(livingroom);
        rooms.add(bedroom);
        rooms.add(kitchen);
        rooms.add(toilet);
        rooms.add(hall);
        rooms.add(garage);
        return rooms;
    }
}
