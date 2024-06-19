package faang.school.godbless.BJS211809;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private static final int NUMBERS_OF_THREADS = 5;
    private static final int DELAY_SECONDS = 30;
    private static final int AWAIT_SECONDS = 90;
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.collectedFood = new ArrayList<>();
    }

    public void collectFood(int id) {
        List<Room> twoRooms = rooms.subList(id, id + 2);
        for (Room room : twoRooms) {
            collectedFood.addAll(room.getFoods());
            room.setFoods(null);
        }
    }

    public static void main(String[] args) {

        House house = initialize();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUMBERS_OF_THREADS);

        for (int i = 0; i <= NUMBERS_OF_THREADS; i++) {
            int roomId = 2 * i;
            executorService.schedule(() -> house.collectFood(roomId), DELAY_SECONDS, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(AWAIT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(executorService.isTerminated());
        System.out.println("Еда собрана!, ее количество = " + house.collectedFood.size());
    }

    private static House initialize() {
        List<Food> foodsDiningRoom = List.of(
                new Food("Dumplings", 10),
                new Food("Steak", 3),
                new Food("Pizza", 4),
                new Food("Salad", 3),
                new Food("Sushi", 5),
                new Food("Burger", 2)
        );

        List<Food> foodsBedRoom = List.of(
                new Food("Pasta", 2),
                new Food("Bun", 3),
                new Food("Taco", 4),
                new Food("Soup", 4),
                new Food("Sandwich", 3),
                new Food("Cake", 1)
        );

        List<Food> foodsBathRoom = List.of(
                new Food("Apple", 2),
                new Food("Banana", 3),
                new Food("Blackberry", 4),
                new Food("Strawberry", 4),
                new Food("Orange", 5),
                new Food("Grapes", 2)
        );

        List<Food> foodsLivingRoom = List.of(
                new Food("Cookies", 10),
                new Food("Milk", 3),
                new Food("Tea", 4),
                new Food("Coffee", 3),
                new Food("Brownie", 5),
                new Food("Pie", 2)
        );

        List<Food> foodsKitchen = List.of(
                new Food("Bread", 8),
                new Food("Butter", 3),
                new Food("Jam", 4),
                new Food("Cheese", 3),
                new Food("Ham", 5),
                new Food("Eggs", 12)
        );

        Room diningRoom = new Room(0, foodsDiningRoom);
        Room bedRoom = new Room(1, foodsBedRoom);
        Room bathRoom = new Room(2, foodsBathRoom);
        Room livingRoom = new Room(3, foodsLivingRoom);
        Room kitchen = new Room(4, foodsKitchen);

        Room diningRoomWhite = new Room(5, foodsDiningRoom);
        Room bedRoomWhite = new Room(6, foodsBedRoom);
        Room bathRoomWhite = new Room(7, foodsBathRoom);
        Room livingRoomWhite = new Room(8, foodsLivingRoom);
        Room kitchenWhite = new Room(9, foodsKitchen);


        return new House(List.of(diningRoom, bedRoom, bathRoom, livingRoom, kitchen,
                diningRoomWhite, bedRoomWhite, bathRoomWhite, livingRoomWhite, kitchenWhite));
    }
}
