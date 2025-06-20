package school.faang.forcebro;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForceBroTesting {
    public static void main(String[] args) {
        Game game = new Game();


        for (int i = 0; i < 100; i++) {
            if (game.isGameOver()) {
                break;
            }
            boolean earnedPoints = Math.random() < 0.5;
            boolean lostLife = Math.random() < 0.3;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
