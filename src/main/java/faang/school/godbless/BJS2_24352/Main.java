package faang.school.godbless.BJS2_24352;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        Game game = new Game(0,0);
        Player attacker = new Player("Attacker", 9);
        Player defender = new Player("Defender", 6);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executor.submit(() -> {
                while(attacker.getLives() > 0 && defender.getLives() > 0)
                    game.update(attacker, defender);
            });
        }
        executor.shutdown();
    }
}
