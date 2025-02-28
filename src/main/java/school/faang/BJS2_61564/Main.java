package school.faang.BJS2_61564;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_SIZE = 3;

    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("Рыцарь");
        roles.add("Берсерк");
        roles.add("Дозорный");
        House house = new House(roles);
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);
        User user1 = new User("Мелисса");
        User user2 = new User("Таргарион");
        User user3 = new User("Эльмар");
        User user4 = new User("Эдрик");
        User user5 = new User("Селина");
        User user6 = new User("Арвен");
        List<User> users = List.of(user1, user2, user3, user4, user5, user6);
        for (User user : users) {
            executor.submit(() -> user.joinHouse(house));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.print("Executor did not terminate within 5 seconds.\n");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.err.printf("Error: %s\n", e.getMessage());
        }
    }

}
