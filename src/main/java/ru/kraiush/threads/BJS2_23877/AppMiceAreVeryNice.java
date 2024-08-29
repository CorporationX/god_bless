package ru.kraiush.threads.BJS2_23877;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppMiceAreVeryNice {
    public static void main(String[] args) throws InterruptedException {

        Room living = new Room("living");
        Room kitchen = new Room("kitchen");
        Room bedroom = new Room("bedroom");

        List<Food> livingFoods = new ArrayList<>();
        livingFoods.add(new Food("Orange", 7));
        livingFoods.add(new Food("Pineapple", 3));
        living.setListFoods(livingFoods);

        List<Food> kitchenFoods = new ArrayList<>();
        kitchenFoods.add(new Food("Cake", 1));
        kitchenFoods.add(new Food("Banana", 7));
        kitchen.setListFoods(kitchenFoods);

        List<Food> bedroomFoods = new ArrayList<>();
        bedroomFoods.add(new Food("Ice cream", 2));
        bedroom.setListFoods(bedroomFoods);

        List<Missia> listMissions = new ArrayList<>();

        listMissions = collectFood(living, livingFoods, listMissions);
        listMissions = collectFood(kitchen, kitchenFoods, listMissions);
        listMissions = collectFood(bedroom, bedroomFoods, listMissions);

        System.out.print(String.join("", Collections.nCopies(130, "-")));
        System.out.println("\nList of missions: rooms with foods in them");
        System.out.println(listMissions);

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        poolExcecutors(scheduledThreadPool, listMissions);
        System.out.print(String.join("", Collections.nCopies(130, "-")));
    }

    static void poolExcecutors(ScheduledExecutorService scheduledThreadPool, List<Missia> listMissions) throws InterruptedException {

        System.out.println("\nCurrent Time = " + new Date());
        for (int i = 0; i < listMissions.size(); i++) {
//            Thread.sleep(20000);
            Missia worker = listMissions.get(i);
            scheduledThreadPool.schedule(worker, 5, TimeUnit.SECONDS);
//            scheduledThreadPool.scheduleAtFixedRate(worker, 0, 15, TimeUnit.SECONDS);
        }
        scheduledThreadPool.shutdown();
        while (!scheduledThreadPool.isTerminated()) {
        }
        System.out.println("Current Time = " + new Date());
        System.out.println("\nList of rooms: there is no more food in rooms:");
        System.out.println(listMissions);

        System.out.println("\n <--- All rooms are empty! --->");
    }

    private static List<Missia> collectFood(Room room, List<Food> foods, List<Missia> listMissions) {

        if (room == null || foods == null || listMissions == null) {
            return null;
        }

        Missia missia = new Missia(room.getName());
        missia.setListfoods(foods);
        listMissions.add(missia);

        return listMissions;
    }
}
