package faang.school.godbless.synchronization.ironThrone;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        House stark = new House("Stark");
        ExecutorService usersThreads = Executors.newCachedThreadPool();

        List<User> users = new ArrayList<>();

        users.add(new User("Rob"));
        users.add(new User("John"));
        users.add(new User("Bran"));
        users.add(new User("Davos"));
        users.add(new User("Aria"));


        log.info("Game of thrones begins!");

        users.forEach(user -> usersThreads.submit(() -> user.joinHouse(stark)));

        Thread.sleep(5000);

        var userFromHouse = users.stream()
                .filter(user -> !user.getRole().equals(Role.VAGABOND))
                .findAny();

        userFromHouse.ifPresent(user -> usersThreads.submit(() -> user.leaveHouse(stark)));

        usersState(users);

        users.forEach(user -> usersThreads.submit(() -> user.leaveHouse(stark)));

        usersThreads.shutdown();
        usersThreads.awaitTermination(10, TimeUnit.SECONDS);

        log.info("Game of thrones terminated.");

        usersState(users);
    }

    private static void usersState(List<User> users) {
        log.info("Users state at this point:");
        users.forEach(user -> log.info(user.toString()));
    }
}
