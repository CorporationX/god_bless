package bjs2_61466;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public class Main {
    private static final int USER_COUNT = 8;
    private static final int START_THREAD_DELAY_MS = 100;
    private static final int FAKE_WORK_TIME_MS = 2 * 1000;

    public static void main(String[] args) {
        List<Role> roles = List.of(Role.KNIGHT, Role.LORD, Role.KNIGHT, Role.MAGICIAN, Role.MAGICIAN, Role.LORD);
        House house = new House(roles);

        Thread[] userThreads = new Thread[USER_COUNT];

        for (int i = 0; i < USER_COUNT; i++) {
            userThreads[i] = new Thread(() -> userThreadProc(house));
        }

        for (Thread thread : userThreads) {
            thread.start();
            try {
                Thread.sleep(START_THREAD_DELAY_MS);
            } catch (InterruptedException e) {
                log.error("Sleep завершился ошибкой: {}", e.getMessage(), e);
            }
        }

        for (Thread thread : userThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ожидание завершения потока завершилось ошибкой: {}", e.getMessage(), e);
            }
        }

        log.info("Всё закончилось");
    }

    private static void userThreadProc(House house) {
        User user = new User(UUID.randomUUID().toString());
        try {
            user.joinHouse(house);
            Thread.sleep(FAKE_WORK_TIME_MS);
        } catch (InterruptedException e) {
            log.error("Поток пользователя {} прервался", user.getName(), e);
        } finally {
            user.leaveHouse();
        }
    }
}
