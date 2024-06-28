package faang.school.godbless.broForce;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private int scope;
    private int lives;
    private Object scopeLock = new Object();
    private Object liveLock = new Object();
    private List<Player> players = new ArrayList<>();

    public Game(Integer scope, Integer lives) {
        this.scope = scope;
        this.lives = lives;
    }

    public void update(Player player) {
        boolean isAlive = player.getIsAlive();
        while (isPlayerAlive()) {
            if(isAlive){
                synchronized (liveLock) {
                    scope++;
                    lives--;
                    player.setLeave(player.getLeave() - 1);
                    System.out.println("Атака игрока " + player.getName() + " осталось жизней " + player.getLeave());
                    if (player.getLeave() == 0) {
                        gameOver(player);
                        return;
                    }
                }
            } else {
                synchronized (scopeLock) {
                    player.setScore(player.getScore() + 1);
                    scope++;
                }
            }
        }
    }

    private void gameOver(Player player) {
        System.out.println("Для игрока " + player.getName() + " игра закончилась!");
    }

    public void addPlayer(Player player) {
        players.add(player);
        lives++;
    }

    public boolean isPlayerAlive() {
        synchronized (liveLock) {
            return players.stream().allMatch(p -> p.getLeave() > 0);
        }
    }
}