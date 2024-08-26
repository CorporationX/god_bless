package threadtwo.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREADS = 5;
    private static final int USERS_COUNT = 10;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREADS);

    public static void main(String[] args) {
        Map<String, Integer> roleMap = new HashMap<>();
        roleMap.put("Lord", 1);
        roleMap.put("Knight", 1);
        roleMap.put("Warrior", 1);
        House house = new House("Westerosa", roleMap);

        List<User> users = new ArrayList<>();

        for (int i = 0; i < USERS_COUNT; i++) {
            System.out.println("User " + (i + 1) + ": created");
            users.add(new User("User_" + (i + 1)));
        }

        for (int i = 0; i < USERS_COUNT; i++) {
            int userId = i;
            executor.execute(() -> {
                System.out.println(users.get(userId).getName() + " пытается присоединиться к дому " + house.getName());
                users.get(userId).joinHouse(house);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupted");
                }
                System.out.println(users.get(userId).getName() + " снялся с роли в доме " + house.getName());
                users.get(userId).removeRole(house);
            });
        }
        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все присоединились к домам " +
                        "и отсоединились от домов");
            } else {
                System.out.println("Не все присоединились и отсоединились " +
                        "от домов за отведенное время");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted");
        }
    }
}
