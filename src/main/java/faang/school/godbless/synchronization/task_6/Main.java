package faang.school.godbless.synchronization.task_6;


import faang.school.godbless.synchronization.task_6.model.House;
import faang.school.godbless.synchronization.task_6.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBERS_OF_USERS = 12;
    private static final int POOL_SIZE = 2;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        House lanister = new House("lanister");
        List<User> users = getUsers();
        users.forEach(user -> EXECUTOR.execute(() -> user.joinHouse(lanister)));
        users.forEach(user -> EXECUTOR.execute(() -> user.leaveHouse(lanister)));
        EXECUTOR.shutdown();
        try {
            EXECUTOR.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < NUMBERS_OF_USERS; i++) {
            User user = new User("name " + i);
            users.add(user);
        }
        return users;
    }
}