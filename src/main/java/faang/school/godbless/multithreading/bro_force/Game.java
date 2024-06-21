package faang.school.godbless.multithreading.bro_force;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Game {

    private int score = 0;

    private int lives = 0;

    private boolean isGame = true;

    private List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
    }

    public void update() throws InterruptedException {
        while (isGame) {
            synchronized (this) {
                List<Player> deadListPlayer = players.stream().filter(p -> p.getLives() < 1).toList();
                if (!deadListPlayer.isEmpty()) {
                    gameOver();
                }
                this.notify();
            }

            System.out.println("check game...");
            Thread.sleep(100);
        }
    }

    private void gameOver() {
        System.out.println("Общее кол-во очков: " + score);

        System.out.println("Число жизней: " + lives);

        isGame = false;
    }
}