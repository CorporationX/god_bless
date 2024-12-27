package school.faang.task_48837;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = new House(Set.of(Role.values()));
        ExecutorService executor = Executors.newCachedThreadPool();

        List<User> users = Arrays.asList(
                new User("User1", house),
                new User("User2", house),
                new User("User3", house),
                new User("User4", house),
                new User("User5", house),
                new User("User6", house)
        );

        users.forEach(user -> executor.execute(() -> {
            user.joinHouse();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.warn("Thread {} was interrupted", Thread.currentThread().getName(), e);
            }
            user.leaveHouse();
        }));

        executor.shutdown();
    }

}
