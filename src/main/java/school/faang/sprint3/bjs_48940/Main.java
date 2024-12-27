package school.faang.sprint3.bjs_48940;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_AMOUNT = 7;
    private static final int BATTLE_TIME = 10000;
    private static final int TIMEOUT_BEFORE_TERMINATION = 1;
    private static final String MESSAGE_OF_THREAD_INTERRUPTED = "Поток был прерван!";

    @SneakyThrows
    public static void main(String[] args) {
        House house = houseInitialize();
        List<User> users = usersInitialize(house);
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_AMOUNT);

        for (User user : users) {
            executor.submit(() -> {
                try {
                    user.joinHouse();
                    Thread.sleep(BATTLE_TIME);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    log.info(MESSAGE_OF_THREAD_INTERRUPTED);
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        if (executor.awaitTermination(TIMEOUT_BEFORE_TERMINATION, TimeUnit.MINUTES)) {
            executor.shutdownNow();
        }
    }

    private static House houseInitialize() {
        List<String> roles = new ArrayList<>();

        String[] data = {
                "лорд", "рыцарь", "маг", "лучник", "целитель", "король"
        };

        Collections.addAll(roles, data);

        return new House(roles);
    }

    private static List<User> usersInitialize(House house) {
        List<User> users = new ArrayList<>();

        String[] names = {
                "Sam", "Jack", "Phill", "Max", "Chris", "Cassie", "Peter",
                "Howard", "Bill", "Anthony", "Steve", "Nolan", "Viktor",
                "Erich", "Carter", "Eddie", "Robert", "Ronald", "Vincent"
        };

        for (String name : names) {
            users.add(new User(name, house));
        }

        return users;
    }
}
