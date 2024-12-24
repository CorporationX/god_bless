package school.faang.sprint3.bjs_48206;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int roomsInHouse = 7;
        int foodNamesAmount = 10;

        int numbersOfThreads = 3;
        int delayOnStart = 1;
        int timeOut = 1;
        int waitingMsec = 1000;

        House house = new House(addRooms(roomsInHouse, foodNamesAmount));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(numbersOfThreads);
        executorService.scheduleAtFixedRate(house::collectFood, delayOnStart, timeOut, TimeUnit.SECONDS);

        log.info("Cleaning started...");
        try {
            while (!house.allFoodCollected()) {
                Thread.sleep(waitingMsec);
            }
            log.info("All food collected");
            executorService.shutdown();
        } catch (InterruptedException e) {
            log.warn("Something went wrong - threads forced to stop");
            executorService.shutdownNow();
        }
    }

    public static List<Room> addRooms(int roomNumbers, int foodAmount) {
        List<Food> foods = generateFoodList(foodAmount);
        List<Room> rooms = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < roomNumbers; i++) {
            int number = random.nextInt(100, 200);
            Room roomN = new Room(number);
            for (int j = 0; j < foodAmount; j++) {
                Food foodObj = foods.get(random.nextInt(foods.size()));
                roomN.addFood(foodObj);
            }
            log.info("Food delivered to the room {}", number);
            rooms.add(roomN);
        }
        return rooms;
    }

    public static List<Food> generateFoodList(int amount) {
        List<Food> foods = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < amount; i++) {
            String foodType = faker.food().toString();
            foods.add(new Food(foodType));
        }
        return foods;
    }
}
