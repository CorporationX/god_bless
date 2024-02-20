package faang.school.godbless.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Room> rooms;
    private List<Food> gatheredFood = new ArrayList<>();
    private static final int THREAD_AMOUNT = 5;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }


    public void collectFood() {
        this.getRooms().forEach(room -> {
            gatheredFood.addAll(room.getFood());
            room.getFood().clear();
        });

    }

    public static void main(String[] args) {
        List<Food> list1 = new ArrayList<>();
        list1.add(new Food("Apple", 5));
        list1.add(new Food("Banana", 3));
        list1.add(new Food("Orange", 8));
        list1.add(new Food("Grapes", 4));
        list1.add(new Food("Strawberry", 10));
        list1.add(new Food("Pineapple", 2));
        list1.add(new Food("Orange", 8));
        list1.add(new Food("Grapes", 4));
        list1.add(new Food("Strawberry", 10));
        list1.add(new Food("Pineapple", 2));
        list1.add(new Food("Orange", 8));
        list1.add(new Food("Grapes", 4));
        list1.add(new Food("Strawberry", 10));
        list1.add(new Food("Pineapple", 2));

        List<Food> list2 = new ArrayList<>();
        list2.add(new Food("Orange", 8));
        list2.add(new Food("Grapes", 4));
        list2.add(new Food("Strawberry", 10));
        list2.add(new Food("Pineapple", 2));
        list2.add(new Food("Orange", 8));
        list2.add(new Food("Grapes", 4));
        list2.add(new Food("Strawberry", 10));
        list2.add(new Food("Pineapple", 2));
        list2.add(new Food("Orange", 8));
        list2.add(new Food("Grapes", 4));
        list2.add(new Food("Strawberry", 10));
        list2.add(new Food("Pineapple", 2));


        Room room1 = new Room(list1);
        Room room2 = new Room(list2);

        List<Room> rooms = List.of(room1, room2);
        House house = new House(rooms);

        ScheduledExecutorService executors = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executors.schedule(() -> {
                try {
                    house.collectFood();
                    System.out.println("The food is gathered");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, 3, TimeUnit.SECONDS);
        }

        executors.shutdown();
        while (!executors.isTerminated()) {
            try {
                Thread.sleep(300);
                System.out.println("Collecting is still in progress...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Collecting is done!");

    }
}
