package derschrank.sprint03.task10.bjstwo_48849;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int DEFAULT_COUNT_OF_ROLES = 5;
    private static final int DEFAULT_COUNT_OF_USERS = 10;
    private static final int DEFAULT_SIZE_OF_POOL = 10;
    private static final int DEFAULT_TIME_OF_OWNERSHIP_OF_ROLE = 2;
    private static final int DEFAULT_TIME_TO_AWAIT = 120;


    public static void main(String[] args) {
        ScheduledExecutorService executorForGetRole = Executors.newScheduledThreadPool(DEFAULT_SIZE_OF_POOL);
        ScheduledExecutorService executorForReleaseRole = Executors.newScheduledThreadPool(DEFAULT_SIZE_OF_POOL);
        List<Role> roles = getRoles();
        List<User> users = getUsers();

        HouseInterface house = new House(roles);
        for (User user : users) {
            Runnable releaseRoleRunnable = user::leaveHouse;
            Runnable getRoleRunnable = () -> {
                user.joinHouse(house);
                executorForReleaseRole.schedule(releaseRoleRunnable,
                        DEFAULT_TIME_OF_OWNERSHIP_OF_ROLE, TimeUnit.SECONDS);
            };

            executorForGetRole.execute(getRoleRunnable);
        }

        executorsShutdownAndAwait(executorForGetRole, executorForReleaseRole);
        System.out.println("End!");
    }

    private static List<Role> getRoles() {
        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < DEFAULT_COUNT_OF_ROLES; i++) {
            roles.add(new Role("Role " + i));
        }
        return roles;
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < DEFAULT_COUNT_OF_USERS; i++) {
            users.add(new User("User " + i));
        }
        return users;
    }

    private static void executorsShutdownAndAwait(ExecutorService ... executors) {
        for (ExecutorService executor : executors) {
            executor.shutdown();
            try {
                executor.awaitTermination(DEFAULT_TIME_TO_AWAIT, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.out.println("executorsShutdownAndAwait was interrupted: " + e);
            }
        }
    }
}
