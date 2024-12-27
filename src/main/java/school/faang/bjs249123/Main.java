package school.faang.bjs249123;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
public class Main {
    private static final int NUMBER_PLAYERS = 10;
    private static final long TIME_DELAY_FINISH = 60;
    public static final int GAME_STEP = 1000;
    public static final int DELAY_JOIN_GAME_MAX = 3;
    public static final int FIRST_USER = 0;

    public static void main(String[] args) {

        List<String> roles = new ArrayList<>();
        List<User> players = new ArrayList<>();
        roles.add("лорд");
        roles.add("рыцарь");
        roles.add("маг");

        House house = new House(roles);
        Random random = new Random();

        Thread daemonThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

                int playerSize = players.size();
                System.out.println("Количество players: " + playerSize);
                if (playerSize > 0) {
                    User randomUser = players.remove(FIRST_USER);
                    randomUser.leaveHouse();
                }
                try {
                    Thread.sleep(GAME_STEP);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        ScheduledExecutorService[] executorServices = new ScheduledExecutorService[NUMBER_PLAYERS];

        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            AtomicInteger num = new AtomicInteger(i);

            int timeDelay = random.nextInt(DELAY_JOIN_GAME_MAX);
            System.out.println(String.format("Player войдет в игру через %s секунд", timeDelay));

            AtomicInteger randomTimeDelay = new AtomicInteger(timeDelay);
            executorServices[i] = Executors.newSingleThreadScheduledExecutor();
            executorServices[i].schedule(() -> {
                try {
                    User user = new User(String.format("player %s", num));
                    user.joinHouse(house);
                    players.add(user);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }, randomTimeDelay.get(), TimeUnit.SECONDS);
        }

        for (ScheduledExecutorService executor : executorServices) {
            executor.shutdown();
        }

        for (ScheduledExecutorService executor : executorServices) {
            try {
                if (!executor.awaitTermination(TIME_DELAY_FINISH, TimeUnit.SECONDS)) {
                    System.out.println(String.format("Some tasks for %s did not complete in time", executor));
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Await termination interrupted!");
            }
        }
        System.out.println("Конец игры.");
    }
}
