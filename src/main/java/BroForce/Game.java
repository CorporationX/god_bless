package BroForce;

import lombok.Getter;

@Getter
public class Game {
    private int score = 0;
    private int lives = 0;
    private final Object liveLock = new Object();
    private final Object scoreLock = new Object();
    private boolean isDead = false;

    public synchronized void update(Player player) {
        //Если кто-то уже умер - выходим из метода
        if (isDead) {
            return;
        }
        //Обновляем очки
        score += player.getScoreUpdater().getScore();
        System.out.println("Игрок " + player + " зарабатывает " + player.getScoreUpdater().getScore() + " очков");
        //Проверяем, нужно ли обновлять жизни
        if (player.getLives() == 1) {
            gameOver(player);
            isDead = true;
        } else {
            if (player.livesUpdater.getLives() > 0) {
                lives += player.getLivesUpdater().getLives();
                System.out.println("Игрок " + player + " теряет 1 жизнь");
            }
        }
    }

    public synchronized void gameOver(Player player) {
        System.out.println("Игра окончена, игрок " + player + " умер");
        isDead = true;
    }
}
