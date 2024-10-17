package school.faang.broforce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    private int score;
    private int lives;
    private final Object lockerOne;
    private final Object lockerTwo;
    private final List<Player> players;

    public Game(List<Player> players) {
        this.score = 0;
        this.lives = players.stream()
                .map(Player::hitPoints)
                .reduce(0, Integer::sum);
        this.players = players;
        this.lockerOne = new Locker();
        this.lockerTwo = new Locker();
    }

    public void start() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        update(service);
        try {
            service.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Ошибка при выполнении метода start()", e);
        }
        if (lives <= 0) {
            gameOver();
        }
        service.shutdown();
    }

    public void update(ExecutorService service) {
        for (Player player : players) {
                service.submit(() ->{
                    while (lives > 0) {
                        int chance = player.getScore();
                        if (chance == 1) {
                            upScore();
                            System.out.println("игрок " + player.name() + " набрал  очки");
                        } else if (chance == 2) {
                            livesUpdate();
                            System.out.println("игрок " + player.name() + " потерял HP");
                        }
                    }
            });
        }
    }

    public void upScore() {
        synchronized (lockerOne){
            this.score++;
        }
    }

    public void livesUpdate() {
        synchronized (lockerTwo) {
            this.lives--;
        }
    }

    public void gameOver() {
        System.out.println("игра окончена, счет равен == " + score);
    }
}
