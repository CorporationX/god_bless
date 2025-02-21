package school.faang.micearenice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class House {

    private static final int THREAD_NUM = 5;
    private static final int DELAY_TIME = 0;
    private static final int PERIOD_TO_REPEAT = 30;
    private static final int TIME_OUT = 30;
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
        if (rooms.isEmpty()) {
            return;
        }
        Room firstRoom = rooms.get(random.nextInt(rooms.size()));
        Room secondRoom;
        do {
            secondRoom = rooms.get(random.nextInt(rooms.size()));
        } while (firstRoom == secondRoom);
        if (firstRoom.getFoods().isEmpty() && secondRoom.getFoods().isEmpty()) {
            return;
        }
        collectedFood.addAll(firstRoom.getFoods());
        log.info("В комнате: {} собрано еды (шт): {}", firstRoom.getName(), firstRoom.getFoods().size());
        collectedFood.addAll(secondRoom.getFoods());
        log.info("В комнате: {} собрано еды (шт): {}", secondRoom.getName(), secondRoom.getFoods().size());
        firstRoom.clearFood();
        secondRoom.clearFood();
        log.info("В комнатах {} и {} собрана еда", firstRoom.getName(), secondRoom.getName());
        rooms.remove(firstRoom);
        rooms.remove(secondRoom);
        if (rooms.isEmpty()) {
            shutdownExecutor();
        }
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
