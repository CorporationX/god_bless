package school.faang.bjs282270;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        House stark = new House("Stark", Arrays.asList("Lord", "Knight", "Maester"));

        List<User> users = Arrays.stream(new String[] {
                        "Jon Snow", "Arya Stark", "Sansa Stark", "Bran Stark", "Robb Stark"
                })
                .map(name -> new User(name, null, null))
                .collect(Collectors.toList());

        List<Thread> threads = IntStream.range(0, users.size())
                .mapToObj(i -> {
                    User user = users.get(i);
                    return new Thread(() -> {
                        try {
                            user.joinHouse(stark);
                            Thread.sleep(2000 + (long) (Math.random() * 3000));
                            user.leaveHouse();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }, "Thread-" + user.getName().replace(" ", "-"));
                })
                .collect(Collectors.toList());

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        log.info("Симуляция завершена!");
    }
}