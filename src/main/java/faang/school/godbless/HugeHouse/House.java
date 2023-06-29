package faang.school.godbless.HugeHouse;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    Iterator<Room> pointer;

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
        pointer = rooms.iterator();
    }

    public synchronized void collectFood() {
        for (int i = 0; i < 2; i++) {
            if (pointer.hasNext()) {
                var food = pointer.next().getFood();
                System.out.println(food + " " + Thread.currentThread().getName());
                collectedFood.addAll(food);
                pointer.remove();
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        House house = new House();
        var executor = Executors.newScheduledThreadPool(5);

        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(List.of(new Food("Apple"), new Food("Banana"))));
        rooms.add(new Room(List.of(new Food("Pizza"), new Food("Burger"))));
        rooms.add(new Room(List.of(new Food("Apple2"), new Food("Banana2"))));
        rooms.add(new Room(List.of(new Food("Pizza2"), new Food("Burger2"))));
        rooms.add(new Room(List.of(new Food("Apple3"), new Food("Banana3"))));
        rooms.add(new Room(List.of(new Food("Pizza3"), new Food("Burger3"))));

        house.setRooms(rooms);
        for (int i = 0; i < 5; i++) {
            executor.schedule(
                    house::collectFood,
                    3,
                    TimeUnit.SECONDS
            );
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(house.getRooms());
        System.out.println(house.getCollectedFood());
    }
}
