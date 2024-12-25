package school.faang.bjs249123;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@Slf4j
public class Main {
    private static final int NUM_THREADS = 1;
    private static final int NUMBER_PLAYERS = 10;
    private static final long SERVICE_OPENING_HOURS = 60;
    private static final long TIME_DELAY_FINISH = 1;
    public static final int TIME_STEP = 1000;
    public static final int DELAY_GAME = 1000;

    public static void main(String[] args) throws InterruptedException {

        List<String> roles = new ArrayList<>();
        List<User> users = new ArrayList<>();
        roles.add("лорд");
        roles.add("рыцарь");
        roles.add("маг");

        House house = new House(roles);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        Runnable task = () -> {
            System.out.println("Старт игры...");
            for (int i = 0; i < NUMBER_PLAYERS; i++) {
                User user = new User(String.format("player %s", i));
                try {
                    user.joinHouse(house);
                    users.add(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Конец игры.");
        };

        Future<?> future = executor.submit(task);
        Thread.sleep(TIME_STEP);

        Thread daemonThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    int index = random.nextInt(users.size());
                    User randomUser = users.get(index);
                    randomUser.leaveHouse();
                    Thread.sleep(DELAY_GAME);
                } catch (InterruptedException e) {
                    System.out.println("Поток-демон был прерван.");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            future.get(SERVICE_OPENING_HOURS, TimeUnit.SECONDS);
        } catch (TimeoutException ex) {
            log.error("Время работы истекло! Прерываем поток... {}", String.valueOf(ex));
            future.cancel(true);
        } catch (InterruptedException | ExecutionException ex) {
            log.error("Error interrupted! {}", String.valueOf(ex));
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(TIME_DELAY_FINISH, TimeUnit.SECONDS)) {
                    System.out.println("Принудительное завершение пула потоков.");
                    executor.shutdownNow();
                }
            } catch (InterruptedException ex) {
                executor.shutdownNow();
                log.error("Everything is bad! {}", String.valueOf(ex));
            }
        }
    }
}
