package school.faang.miceareverynice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Room> rooms;
    private final List<Food> allFoods;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.allFoods = new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Room> myRooms = new ArrayList<>();
        myRooms.add(new Room(List.of(new Food("Банан"), new Food("Аппельсин"))));
        myRooms.add(new Room(List.of(new Food("Тыква"), new Food("Сыр"))));
        myRooms.add(new Room(List.of(new Food("Рыба"), new Food("Мясо"))));
        myRooms.add(new Room(List.of(new Food("Баклажан"), new Food("Соль"), new Food("Перец"))));
        myRooms.add(new Room(List.of(new Food("Шпроты"), new Food("Капуста"), new Food("Чили"))));
        myRooms.add(new Room(List.of(new Food("Сахар"), new Food("Кефир"), new Food("Перец"))));
        House myHouse = new House(myRooms);

        System.out.println(myHouse.rooms);
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        Runnable runnable = () -> myHouse.collectFood(myHouse, service);
        for (int i = 0; i < 5; i++) {
            service.scheduleWithFixedDelay(runnable, 0, 1, TimeUnit.SECONDS);
        }
    }

    public void collectFood(House house, ScheduledExecutorService service) {
        if (!allFoodCollected(house)) {
            System.out.println("I am here " + Thread.currentThread().getName());
            Random random = new Random();
            int randomRoomOne = random.nextInt(house.rooms.size());
            int randomRoomTwo = random.nextInt(house.rooms.size());
            Room roomOne = house.rooms.get(randomRoomOne);
            Room roomTwo = house.rooms.get(randomRoomTwo);
            System.out.println("Теперь я тут " + Thread.currentThread().getName());
            house.allFoods.addAll(roomOne.foodsOfThisRoom());
            house.rooms.remove(roomOne);
            house.allFoods.addAll(roomTwo.foodsOfThisRoom());
            house.rooms.remove(roomTwo);
        } else {
            service.shutdown();
            System.out.println("FINISHED!!! "  + Thread.currentThread().getName());
            System.out.println(house.rooms);
            System.out.println(house.allFoods);
        }
    }

    private boolean allFoodCollected(House house) {
        return house.rooms.isEmpty();
    }
}
