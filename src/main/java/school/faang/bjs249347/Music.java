package school.faang.bjs249347;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();
        List<Consumer<Player>> userActions = List.of(Player::play, Player::pause, Player::previous, Player::skip);

        Random random = new Random();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        service.scheduleAtFixedRate(() -> {
            int randomAction = random.nextInt(0, userActions.size());
            Consumer<Player> userAction = userActions.get(randomAction);
            userAction.accept(player);
        }, 0, 1, TimeUnit.SECONDS);

        try {
            if (service.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("All tasks completed");
            } else {
                service.shutdown();
                System.out.println("Forced termination");
            }
        } catch (InterruptedException e) {
            System.out.println("Not all tasks were completed");
        }
    }
}
