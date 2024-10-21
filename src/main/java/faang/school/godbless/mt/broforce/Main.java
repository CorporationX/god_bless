package faang.school.godbless.mt.broforce;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            game.update(random.nextBoolean(), random.nextBoolean());
            if (game.isOver()) return;
            Thread.sleep(100);
        }
    }
}
