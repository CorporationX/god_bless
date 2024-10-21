package tasks.bjs2_37309;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Music {
    private final Random random = new Random();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

    public static void main(String[] args) {
        Player player1 = new Player("Александр");
        Player player2 = new Player("Владимер");
        Player player3 = new Player("Евгений");
        Music music = new Music();

        music.simulateUserActions(player1);
        music.simulateUserActions(player2);
        music.simulateUserActions(player3);
        music.scheduler.shutdown();

        try {
            if (music.scheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Пользователи закончили работу с плеером");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("В процессе работы с плером произошла ошибка : " + e.getMessage());
        }
    }

    public void simulateUserActions(Player player) {
        scheduler.schedule(player::play, random.nextInt(0, 10), TimeUnit.SECONDS);
        scheduler.schedule(player::skip, random.nextInt(0, 10), TimeUnit.SECONDS);
        scheduler.schedule(player::pause, random.nextInt(0, 10), TimeUnit.SECONDS);
        scheduler.schedule(player::previous, random.nextInt(0, 10), TimeUnit.SECONDS);
    }
}
