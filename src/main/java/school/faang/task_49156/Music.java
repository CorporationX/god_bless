package school.faang.task_49156;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        List<Consumer<Player>> consumers = new ArrayList<>();
        consumers.add(Player::play);
        consumers.add(Player::skip);
        consumers.add(Player::pause);
        consumers.add(Player::previous);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        Random rand = new Random();

        executor.scheduleAtFixedRate(() -> {
            int index = rand.nextInt(0, consumers.size());
            Consumer<Player> consumer = consumers.get(index);
            consumer.accept(player);
        }, 0, 1, TimeUnit.SECONDS);

        try {
           if(executor.awaitTermination(5, TimeUnit.SECONDS)){
               System.out.println("Работа завершена полноценно");
           }
           else{
               executor.shutdownNow();
               System.out.println("Принудительное завершение");
           }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Произведение закончено");
    }
}
