package faang.school.godbless.BroForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Bro attacker = new Bro("Attacker", 10);
        Bro defender = new Bro("Defender", 6);

        int threadCount = 2;

        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            service.submit(() -> {
                while(attacker.isAlive() && defender.isAlive())
                    game.update(attacker, defender);
            });
        }

        service.shutdown();
    }
}