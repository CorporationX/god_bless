package school.faang.bjs2_82057;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 100; i++) {
            if (game.isOver()) {
                break;
            }

            boolean earnedPoints = Math.random() < 0.5;
            boolean lostLife = Math.random() < 0.8;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("поток прерван во время Zzz", e);
            }
        }
    }
}
