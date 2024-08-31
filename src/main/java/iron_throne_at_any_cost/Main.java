package iron_throne_at_any_cost;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        House starks = new House("Starks", List.of(Role.values()));
        List<User> users = List.of(
                new User("khaleesi", starks, Role.MAGE),
                new User("hodooooooooor", starks, null),
                new User("john_snow2005 ", starks, Role.KNIGHT),
                new User("x_baratheon_x", starks, null),
                new User("wannabelord", starks, null)
        );
        ExecutorService executorService = Executors.newFixedThreadPool(users.size());
        users.forEach(user -> executorService.execute(() -> {
            if (user.getRole() == null) {
                user.joinHouse();
            } else {
                user.leaveHouse();
            }
            System.out.println(user.getName() + " " + user.getRole());
        }));

        if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            executorService.shutdown();
            System.out.println("Выполнение программы успешно завершено");
        } else {
            executorService.shutdownNow();
            System.out.println("Время выполнения программы превышено");
        }
    }
}
