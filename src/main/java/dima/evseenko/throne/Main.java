package dima.evseenko.throne;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (User user : getUsers()) {
            executorService.submit(() -> {
                try {
                    user.joinHouse(house, getRandomRole());
                    Thread.sleep(5000);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Ошибка присоединения %s к роли %s".formatted(user.getName(), user.getRole()), e);
                }
            });
        }

        executorService.shutdown();
    }

    private static Role getRandomRole() {
        return switch (new Random().nextInt(3)) {
            case 0 -> Role.MAGE;
            case 1 -> Role.KNIGHT;
            case 2 -> Role.LORD;
            default -> null;
        };
    }

    private static List<User> getUsers() {
        return List.of(
                new User("Dima"),
                new User("Vasya"),
                new User("Kolya"),
                new User("Petya"),
                new User("Sasha"),
                new User("Masha"),
                new User("Igor"),
                new User("Danil")
        );
    }
}
