package faang.school.godbless.iron_throne;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_NUM = 5;
    private static final int TIME_LIMIT = 30;

    public static void main(String[] args) {
        List<User> userList = getUserList();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        System.out.println(userList.get(0).getHouse().getAllRoles());

        userList.forEach(
                user ->
                        executorService.execute(() -> {
                            try {
                                user.joinHouse();

                                Thread.sleep(5000);

                                user.leaveHouse();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }));

        executorService.shutdown();

        try {
            boolean areThreadsFinishedOnTime = executorService.awaitTermination(TIME_LIMIT, TimeUnit.SECONDS);
            if (areThreadsFinishedOnTime) {
                System.out.println("Threads finished on time");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<User> getUserList() {
        House houseFirst = new House("SomeHouseName");
        House houseSecond = new House("AnotherHouseName");

        return List.of(
                new User(houseFirst), new User(houseFirst), new User(houseFirst), new User(houseFirst),
                new User(houseSecond), new User(houseSecond), new User(houseSecond), new User(houseSecond),
                new User(houseFirst), new User(houseFirst), new User(houseFirst), new User(houseFirst),
                new User(houseSecond), new User(houseSecond), new User(houseSecond), new User(houseSecond)
        );
    }
}
