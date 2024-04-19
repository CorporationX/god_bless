package faang.school.godbless.bjs2_5632;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Role lord = new Role("Lord");
        Role mage = new Role("Mage");
        Role knight = new Role("Knight");

        House stark = new House("Stark");
        stark.getRoles().put(lord, 1);
        stark.getRoles().put(mage, 1);
        stark.getRoles().put(knight, 3);

        User vasya = new User("Vasya");
        User petr = new User("Petr");
        User kolya = new User("Kolya");
        User dima = new User("Dima");
        User michael = new User("Michael");
        List<User> users = List.of(vasya, petr, kolya, dima, michael);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(() -> vasya.joinHouse(stark, lord));
        executor.execute(() -> petr.joinHouse(stark, mage));
        executor.execute(() -> kolya.joinHouse(stark, knight));
        executor.execute(() -> dima.joinHouse(stark, lord));
        executor.execute(() -> michael.joinHouse(stark, lord));
        Thread.sleep(5000);

        executor.execute(() -> vasya.leaveHouse(stark));

        Thread.sleep(5000);
        System.out.println("\nFreeing up the role of Lord.");
        for (User user : users) {
            if (user.getRole() != null && user.getRole().equals(lord)) {
                executor.execute(() -> user.leaveHouse(stark));
            }
        }

        executor.shutdown();

        try {
            while (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nCurrent roles for users:");
        users.forEach(user -> System.out.println(user.getName() + " has role " + user.getRole().getName()));

        System.out.println("\nRoles in house Stark:");
        stark.getRoles().forEach((key, value) -> System.out.println(key.getName() + " : " + value));
    }
}
