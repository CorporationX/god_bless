package school.faang.bjs2_82105;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(4);

        for (int i = 0; i < 1000; i++) {
            boolean earnedPoints = LocalDateTime.now().getNano() % 2 == 0;
            boolean lostLife = LocalDateTime.now().getSecond() % 2 != 0;
            try {
                game.update(earnedPoints, lostLife);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
