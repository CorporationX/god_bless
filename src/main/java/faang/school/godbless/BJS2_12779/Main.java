package faang.school.godbless.BJS2_12779;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        List<String> roles = List.of("лорд", "рыцарь", "маг");
        List<House> houses = List.of(new House("Таргариены", roles),
                new House("Ланнистеры", roles),
                new House("Старки", roles));
        List<User> users = List.of(new User("пользователь_1"),
                new User("пользователь_2"),
                new User("пользователь_3"),
                new User("пользователь_4"),
                new User("пользователь_5"),
                new User("пользователь_6"),
                new User("пользователь_7"),
                new User("пользователь_8"),
                new User("пользователь_9"),
                new User("пользователь_10"),
                new User("пользователь_11"));

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            users.forEach(user -> executorService.submit(() -> {
                try {
                    joinToHouse(houses, user);
                    Thread.sleep(100);
                    leaveTheHouse(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        executorService.shutdown();
    }

    private static void joinToHouse(List<House> houses, User user) throws InterruptedException {
        House house = houses.get(rand.nextInt(0, houses.size()));
        user.joinHouse(house);
        System.out.println(user + " joined house: " + house.getName());
    }

    private static void leaveTheHouse(User user) {
        user.leaveHouse(user.getHouse());
        System.out.println(user + " leave house");
    }
}
