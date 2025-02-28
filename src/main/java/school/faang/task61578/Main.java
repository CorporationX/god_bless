package school.faang.task61578;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = new House();
        List<Thread> users = List.of(
                new Thread(() -> {
                    User user = new User("Витёк");
                    user.joinHouse(house);
                }),
                new Thread(() -> {
                    User user = new User("Витёк Младший");
                    user.joinHouse(house);
                }),
                new Thread(() -> {
                    User user = new User("Не Витёк");
                    user.joinHouse(house);
                }),
                new Thread(() -> {
                    User user = new User("Клёвый Витёк");
                    user.joinHouse(house);
                })
        );
        users.forEach(Thread::start);

        try {
            for (Thread thread : users) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при ожидании завершения потоков: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
