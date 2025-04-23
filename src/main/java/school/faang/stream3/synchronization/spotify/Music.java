package school.faang.stream3.synchronization.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) {

        User firstUser = new User("Adam");
        User secondUser = new User("Eve");
        User thirdUser = new User("Solomon");

        firstUser.startNewPlayer();
        secondUser.joinPlayer(firstUser.getPlayer());
        thirdUser.joinPlayer(secondUser.getPlayer());

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new UserAction(firstUser, Player::play));
        executor.execute(new UserAction(secondUser, Player::pause));
        executor.execute(new UserAction(secondUser, p -> p.showNextSongs(3)));
        executor.execute(new UserAction(thirdUser, Player::skip));
        executor.execute(new UserAction(firstUser, Player::play));
        executor.execute(new UserAction(secondUser, Player::pause));
        executor.execute(new UserAction(secondUser, p -> p.showNextSongs(3)));
        executor.execute(new UserAction(firstUser, Player::previous));
        executor.execute(new UserAction(thirdUser, Player::skip));
        executor.execute(new UserAction(secondUser, p -> p.showNextSongs(6)));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(50, TimeUnit.SECONDS)) {
                System.out.println("Задачи не завершились за 50 секунд, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
