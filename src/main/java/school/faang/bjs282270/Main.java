package school.faang.bjs282270;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int SIMULATION_BASE_TIME = 2000;
    private static final int SIMULATION_RANDOM_TIME = 3000;

    public static void main(String[] args) throws InterruptedException {
        House stark = new House("Stark", Arrays.asList("Lord", "Knight", "Maester"));

        List<User> users = createUsers();
        List<Thread> threads = createUserThreads(users, stark);

        startAndWaitForThreads(threads);

        log.info("Симуляция завершена!");
    }

    private static List<User> createUsers() {
        return Arrays.stream(new String[]{
                        "Jon Snow", "Arya Stark", "Sansa Stark", "Bran Stark", "Robb Stark"})
                .map(name -> new User(name))
                .collect(Collectors.toList());
    }

    private static List<Thread> createUserThreads(List<User> users, House house) {
        return IntStream.range(0, users.size())
                .mapToObj(i -> {
                    User user = users.get(i);
                    return new Thread(() -> simulateUserActivity(user, house),
                            "Thread-" + user.getName().replace(" ", "-"));
                })
                .collect(Collectors.toList());
    }

    private static void simulateUserActivity(User user, House house) {
        try {
            user.joinHouse(house);
            Thread.sleep(SIMULATION_BASE_TIME + (long) (Math.random() * SIMULATION_RANDOM_TIME));
            user.leaveHouse();
        } catch (InterruptedException e) {
            log.warn("Поток {} был прерван", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }

    private static void startAndWaitForThreads(List<Thread> threads) throws InterruptedException {
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании завершения потока {}", thread.getName());
                Thread.currentThread().interrupt();
                throw e;
            }
        }
    }
}