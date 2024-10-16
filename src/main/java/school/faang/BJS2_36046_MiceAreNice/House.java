package school.faang.BJS2_36046_MiceAreNice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final int THREADS_COUNT = 5;
    private static final int THREAD_INITIAL_TIME = 0;
    private static final int THREAD_PERIOD_TIME = 30;
    private static final int MAX_WAIT_TIME = 70;

    private List<Room> rooms;
    @Getter
    private ConcurrentLinkedQueue<Food> collectedFoodstuff;
    private List<Room> uncheckedRooms;

    public House() {
        rooms = new ArrayList<>();
        collectedFoodstuff = new ConcurrentLinkedQueue<>();
        uncheckedRooms = new ArrayList<>();
    }

    public House(List<Room> rooms) {
        this.rooms = rooms;
        collectedFoodstuff = new ConcurrentLinkedQueue<>();
        uncheckedRooms = new ArrayList<>(rooms);
        Collections.shuffle(uncheckedRooms);
    }

    public static void main(String[] args) {
        House house = new House();

        house.addRoom(new Room("kitchen", Arrays.asList(new Food("Apple"), new Food("Banana"))));
        house.addRoom(new Room("living room", Arrays.asList(new Food("Cracker"), new Food("Cheese"))));
        house.addRoom(new Room("bedroom", Arrays.asList(new Food("Chocolate"), new Food("Cookies"))));
        house.addRoom(new Room("bathroom", Arrays.asList(new Food("Toothpaste"), new Food("Mouthwash"))));
        house.addRoom(new Room("dining room", Arrays.asList(new Food("Salt"), new Food("Pepper"))));
        house.addRoom(new Room("office", Arrays.asList(new Food("Coffee"), new Food("Donuts"))));
        house.addRoom(new Room("game room", Arrays.asList(new Food("Popcorn"), new Food("Soda"))));
        house.addRoom(new Room("library", Arrays.asList(new Food("Tea"), new Food("Cookies"))));
        house.addRoom(new Room("gym", Arrays.asList(new Food("Protein Bar"), new Food("Fruit Smoothie"))));
        house.addRoom(new Room("attic", Arrays.asList(new Food("Old Candy"), new Food("Dried Fruits"))));
        house.addRoom(new Room("basement", Arrays.asList(new Food("Canned Food"), new Food("Pickles"))));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i++) {
            executor.scheduleAtFixedRate(() -> house.collectFood(executor), THREAD_INITIAL_TIME, THREAD_PERIOD_TIME, TimeUnit.SECONDS);
        }

        try {
            if (executor.awaitTermination(MAX_WAIT_TIME, TimeUnit.SECONDS)) {
                System.out.println("Еда в доме собрана!");
            } else if (house.isAllRoomsCollected()) {
                System.out.println("Хоть время и вышло, но вся еда была собрана!");
            } else {
                System.out.println("Не вся еда была собрана!");
            }
            System.out.printf("Список собранной еды: %s\n", house.getCollectedFoodstuff());
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.err.printf("Interrupted while waiting for chores to finish. Shutting down executor now.\n%s", e.getMessage());
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
        uncheckedRooms.add(room);
        Collections.shuffle(uncheckedRooms);
    }

    public void collectFood(ScheduledExecutorService executor) {
        List<Optional<Room>> twoRandomRooms = Arrays.asList(getRandomRoom(), getRandomRoom());
        twoRandomRooms.forEach(room ->
            room.ifPresentOrElse(
                    randomRoom -> {
                        List<Food> roomFoodstuff = randomRoom.collectAndClearFoodstuff();
                        collectedFoodstuff.addAll(roomFoodstuff);
                    },
                    () -> {
                        if (uncheckedRooms.isEmpty()) {
                            executor.shutdown();
                        }
                    }
            )
        );
    }

    public boolean isAllRoomsCollected() {
        return uncheckedRooms.isEmpty();
    }

    private synchronized Optional<Room> getRandomRoom() {
        if (uncheckedRooms.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(uncheckedRooms.remove(uncheckedRooms.size() - 1));
    }
}
