package school.faang.theirontroneatanycost;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.*;

@Slf4j
public class Main {
    private static final int USER_COUNT = 6;

    public static void main(String[] args) throws InterruptedException {
        Random rnd = new Random();

        Set<Role> roles = new HashSet<>();
        String[] roleNames = {"Warrior", "Mage", "Rogue"};
        for (String name : roleNames) {
            roles.add(new Role(rnd.nextInt(), name));
        }

        House house = new House(roles);

        ExecutorService executor = Executors.newFixedThreadPool(USER_COUNT);

        for (int i = 1; i <= USER_COUNT; i++) {
            final String userName = "User-" + i;
            executor.submit(() -> {
                User user = new User(userName);
                List<Role> roleList = new ArrayList<>(roles);
                Role chosen = roleList.get(rnd.nextInt(roleList.size()));
                try {
                    System.out.printf("%s пытается присоединиться как %s…%n", userName, chosen.getName());
                    user.joinHouse(house, chosen);
                    System.out.printf("%s вошёл(ла) в дом как %s%n", userName, chosen.getName());

                    Thread.sleep(500 + rnd.nextInt(1500));

                    user.leaveHouse(house);
                    System.out.printf("%s освободил(а) роль %s и покинул(а) дом%n",
                            userName, chosen.getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.printf("%s был прерван%n", userName);
                }
            });
        }

        executor.shutdown();
        if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
            log.info("Shutting down all users!");
            executor.shutdownNow();
        }
        System.out.println("✅ Все пользователи завершили работу. Программа завершена.");
    }
}