package faang.school.godbless.synchronizationWaitNotify.ironThrone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int NUMBER_THREADS = 10;

    public static void main(String[] args) {
        Map<RoleUser, Integer> mapRoleUsers = new HashMap<>(Map.of(
                RoleUser.HUMAN, 2,
                RoleUser.KNIGHT, 3,
                RoleUser.LORD, 2,
                RoleUser.MAGICIAN, 1
        ));
        House house = new House(mapRoleUsers);

        List<User> users = IntStream.rangeClosed(1, 20).boxed().map(number -> new User("user" + number, house)).toList();

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);

        for (User user : users) {
            executorService.submit(() -> {
                user.joinHouse();
                //имитация игры
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse();
            });
        }

        executorService.shutdown();
    }
}
