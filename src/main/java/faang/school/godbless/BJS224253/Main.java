package faang.school.godbless.BJS224253;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game broForce = new Game(0, 0);
        Player attacker = new Player("Attacker", 10);
        Player defender = new Player("Defender", 6);

        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            service.submit(() -> {
                while(attacker.getLives() > 0 && defender.getLives() > 0)
                    broForce.update(attacker, defender);
            });
        }

        service.shutdown();
    }
}
