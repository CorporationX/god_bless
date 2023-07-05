package Sprint_4_Task19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object scoreLock2 = new Object();

    private void update() {
        synchronized (scoreLock) {
            System.out.println(Thread.currentThread().getName() + " Score: " + score++);
        }
        synchronized (scoreLock2) {
            System.out.println(Thread.currentThread().getName() + " Lives: " + lives--);
            if (lives == 0){
                gameOver();
            }
        }
    }
    private void gameOver() {
            System.out.println("Game Over");
    }

    @SneakyThrows
    public static void main(String[] args) {
        Game game = new Game(0,100);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < game.getLives(); i++){
            executor.submit(game::update);
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
