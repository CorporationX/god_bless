package school.faang.thread4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        House houseWeasley = new House();

        Food soupMerjimek = new Food("Merjimek");
        Food manty = new Food("Manty");
        Food plov = new Food("plov");
        Food soupLagman = new Food("Lagman");
        Food saladOkroshka = new Food("Okroshka");
        Food saladGrecheskiy = new Food("Grecheskiy");
        Food saladMuzskoy = new Food("Muzskoy");
        Food bread = new Food("Bread");
        Food daughnut = new Food("American daughnut");
        Food pie = new Food("Pie");
        Food apple = new Food("Apple");
        Food banana = new Food("Banana");
        Food drinkCola = new Food("Cola");
        Food drinkFanta = new Food("Fanta");
        Food drinkSprite = new Food("Sprite");
        Food drinkVine = new Food("Vine");
        Food drinkVodka = new Food("Vodka");
        Food drinkBeer = new Food("Beer");

        List<Food> foodListKitchen = new ArrayList<>();
        foodListKitchen.add(soupMerjimek);
        foodListKitchen.add(manty);
        foodListKitchen.add(plov);

        List<Food> foodListLivingRoom = new ArrayList<>();
        foodListLivingRoom.add(soupLagman);
        foodListLivingRoom.add(saladOkroshka);
        foodListLivingRoom.add(saladGrecheskiy);

        List<Food> foodListBedroom1 = new ArrayList<>();
        foodListBedroom1.add(saladMuzskoy);
        foodListBedroom1.add(bread);
        foodListBedroom1.add(daughnut);

        List<Food> foodListBedroom2 = new ArrayList<>();
        foodListBedroom2.add(pie);
        foodListBedroom2.add(apple);
        foodListBedroom2.add(banana);

        List<Food> foodListHall = new ArrayList<>();
        foodListHall.add(drinkCola);
        foodListHall.add(drinkFanta);
        foodListHall.add(drinkSprite);

        List<Food> foodListBasement = new ArrayList<>();
        foodListBasement.add(drinkVine);
        foodListBasement.add(drinkVodka);
        foodListBasement.add(drinkBeer);

        Room kitchen = new Room(foodListKitchen);
        Room livingRoom = new Room(foodListLivingRoom);
        Room bedroom1 = new Room(foodListBedroom1);
        Room bedroom2 = new Room(foodListBedroom2);
        Room hall = new Room(foodListHall);
        Room basement = new Room(foodListBasement);


        houseWeasley.getRoomList().add(livingRoom);
        houseWeasley.getRoomList().add(kitchen);
        houseWeasley.getRoomList().add(bedroom1);
        houseWeasley.getRoomList().add(bedroom2);
        houseWeasley.getRoomList().add(hall);
        houseWeasley.getRoomList().add(basement);

        ScheduledExecutorService scheduledThread = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 3; i++) {
            scheduledThread.scheduleAtFixedRate(houseWeasley, 0,
                    30, TimeUnit.SECONDS);
        }


        try {
            scheduledThread.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            scheduledThread.shutdown();
        }

        System.out.println("Food has been collected");
    }
}
