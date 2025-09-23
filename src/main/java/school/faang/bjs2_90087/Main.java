package school.faang.bjs2_90087;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        Game game = new Game(8);

        Runnable playerLifeCycle = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                boolean isScoreEarned = Math.random() < 0.6;
                boolean isLiveLost = Math.random() < 0.5;

                game.update(isScoreEarned, isLiveLost);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                if (!game.isGameInProgress) {
                    break;
                }
            }
        };

        Thread thread1 = new Thread(playerLifeCycle, "SuperBro");
        Thread thread2 = new Thread(playerLifeCycle, "BlackBro");
        Thread thread3 = new Thread(playerLifeCycle, "UnholyBro");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
