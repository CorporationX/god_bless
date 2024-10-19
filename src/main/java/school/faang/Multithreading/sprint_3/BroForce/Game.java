package school.faang.Multithreading.sprint_3.BroForce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private int score;
    private int lives;
    List<Player> playerList = new ArrayList<>();

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update() {
        synchronized (lockScore) {
            for (Player player : playerList) {
                if (!player.hasScorePlayer() && !player.isDiePlayer()) {
                    try {
                        System.out.println("У игрока " + player.getName() + " пока нет очков");
                        lockScore.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Операция была прервана, когда у игрока не было очков" + e.getMessage());
                    }

                }
                score += player.getScorePlayer();
                System.out.println("Общий счетчик был увеличен " + score);
            }
        }

        synchronized (lockLives) {
            for (Player player : playerList) {

                if (!player.isDiePlayer()) {
                    System.out.println("Игрок " + player.getName() + " еще жив");
                    try {
                        lockLives.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Ожидание сметрти прервано");
                    }
                }
                lives--;
                System.out.println("Игрок " + player.getName() + " выбыл из игры \t осталось в живых: " + lives);

                if (allPlayerDie()) {
                    gameOver();
                }
            }
        }
    }

    public  void addPlayer(Player player) {
        playerList.add(player);
        lives++;
    }

    private void gameOver() {
        System.out.println("Игра окончена");
    }

    private boolean allPlayerDie() {
        return lives <= 0;
    }
}
