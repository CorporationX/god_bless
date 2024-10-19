package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Game {

    private final List<Bro> bros;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int totalScore;
    private int totalLives;

    public Game(List<Bro> bros) {
        Objects.requireNonNull(bros, "Bros list cannot be null");
        this.bros = bros;
    }

   public void start() {
       ExecutorService executor = Executors.newFixedThreadPool(bros.size());
       bros.forEach(bro ->
               executor.submit(() -> {
                   while (bro.isAlive()) {
                       update(bro);
                   }
                   log.info("{} is dead", bro.getName());
               })
       );
       executor.shutdown();
       try {
           if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
               executor.shutdownNow();
           }
       } catch (InterruptedException e) {
           executor.shutdownNow();
       }
       gameOver();
   }

   private void update(Bro bro) {
        boolean isAddedScore = Math.random() > 0.5;
        boolean isLostLife = Math.random() > 0.7;

        if (isAddedScore) {
            log.info("{} added score", bro);
            synchronized (scoreLock) {
                totalScore++;
            }
        }

        if (isLostLife) {
            log.info("{} lost life", bro);
            bro.removeLife();
            synchronized (livesLock) {
                totalLives++;
            }
        }
   }

   private void gameOver() {
        log.info("Game over. Total score: {}; Lives spend: {}", totalScore, totalLives);
   }
}
