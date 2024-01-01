package BroForce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private int score;
    private int lives;
    private boolean isAllAlive = true;
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();
    List<Player> players = new ArrayList<>();

    public boolean update() {
        Player currentPlayer = players.get((int) (Math.random() * players.size()));
        //Обновляем очки
        if (updateOrNot()) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Игрок " + currentPlayer.getName() + " зарабатывает 1 очков");
            }
        }
        //Обновляем жизни
        if (updateOrNot()) {
            synchronized (liveLock) {
                //Если в параллельном потоке кто-то уже умер - выходим из метода
                if (!isAllAlive) {
                    return false;
                }

                currentPlayer.updateLives();
                lives++;
                System.out.println("Игрок " + currentPlayer.getName() + " теряет жизнь");
                //Если игрок умер - меняем состояние isAllAlive в Game и isAlive у игрока
                if (currentPlayer.getLives() == 0) {
                    System.out.println("Игрок " + currentPlayer.getName() + " умирает");
                    currentPlayer.setAlive(false);
                    isAllAlive = false;

                    //Завершаем игру
                    return gameOver();
                }
            }
        }
        return true;
    }

    private boolean gameOver() {
        System.out.println("Игра окончена");
        return false;
    }

    //Дает рандомное значение 1 или 0
    private boolean updateOrNot() {
        double random = Math.random();
        if (random >= 0.5) {
            return true;
        }
        return false;
    }
}
