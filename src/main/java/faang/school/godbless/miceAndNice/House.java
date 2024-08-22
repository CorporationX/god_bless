package faang.school.godbless.miceAndNice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;//список собарнной еды

    private static final int ROOM_BUF_SIZE = 2;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        collectedFood = new ArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {
        House house = new House(new ArrayList(List.of(
                new Room("1", new ArrayList<>(List.of(new Food("1"), new Food("2")))),
                new Room("2", new ArrayList<>(List.of(new Food("2"), new Food("8")))),
                new Room("3", new ArrayList<>(List.of(new Food("3"), new Food("8")))),
                new Room("4", new ArrayList<>(List.of(new Food("4"), new Food("8")))),
                new Room("5", new ArrayList<>(List.of(new Food("5"), new Food("8")))),
                new Room("6", new ArrayList<>(List.of(new Food("6"), new Food("8")))),
                new Room("7", new ArrayList<>(List.of(new Food("7"), new Food("8")))),
                new Room("8", new ArrayList<>(List.of(new Food("8"), new Food("8")))),
                new Room("9", new ArrayList<>(List.of(new Food("9"), new Food("8")))),
                new Room("10", new ArrayList<>(List.of(new Food("10"), new Food("8")))),
                new Room("11", new ArrayList<>(List.of(new Food("11"), new Food("8")))),
                new Room("12", new ArrayList<>(List.of(new Food("12"), new Food("8"))))
        )));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        int i;
        for (i = 0; i < house.rooms.size(); i++) {
            if ((i + 1) % ROOM_BUF_SIZE == 0 && i > 0) {
                int finalI = i;
                service.schedule(() -> house.collectFood(finalI - ROOM_BUF_SIZE + 1, finalI + 1),
                        1, TimeUnit.MILLISECONDS);
            }
        }

        if ((i = house.rooms.size() % ROOM_BUF_SIZE) != 0) {
            int finalI = i;
            service.schedule(() -> house.collectFood(house.rooms.size() - finalI,
                    house.rooms.size()), 1, TimeUnit.MILLISECONDS);
        }

        service.shutdown();
    }

    public void collectFood(int start, int end) {
        for (int i = start; i < end; i++) {
            collectedFood.addAll(rooms.get(i).getFood());
            rooms.get(i).getFood().clear();
        }
        System.out.println(start + " - " + end);
    }
}
