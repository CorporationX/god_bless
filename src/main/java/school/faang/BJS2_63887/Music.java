package school.faang.BJS2_63887;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<User> users = new ArrayList<>(List.of(
                new User("Ramil", player),
                new User("Albert", player),
                new User("Kamil", player)
        ));

        ExecutorService executor = newCachedThreadPool();
        try {
            users.forEach(executor::execute);
        } finally {
            executor.shutdown();
        }
    }
}
