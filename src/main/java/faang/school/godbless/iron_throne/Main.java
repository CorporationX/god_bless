package faang.school.godbless.iron_throne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        House house = new House(
                "Vesteross",
                new HashMap<>(Map.of(
                    HouseRole.KING, 1,
                    HouseRole.QUEEN, 1,
                    HouseRole.COOK, 2,
                    HouseRole.SERVANT, 7
        )));
        List<User> users = List.of(
                new User("test1"),
                new User("test2"),
                new User("test3"),
                new User("test4"),
                new User("test5"),
                new User("test6"),
                new User("test7"),
                new User("test8"),
                new User("test9")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (User user : users) {
            executorService.execute(() -> user.joinHouse(house, HouseRole.SERVANT));
        }

        executorService.execute(() -> users.get(1).leaveHouse(house));
        executorService.execute(() -> users.get(2).leaveHouse(house));
        executorService.execute(() -> users.get(3).leaveHouse(house));

        executorService.execute(() -> users.get(1).joinHouse(house, HouseRole.KING));
        executorService.execute(() -> users.get(2).joinHouse(house, HouseRole.KING));

        executorService.execute(() -> users.get(1).leaveHouse(house));

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        System.out.println(house.getRolesMap());
    }
}