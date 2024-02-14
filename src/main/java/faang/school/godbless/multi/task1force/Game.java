package faang.school.godbless.multi.task1force;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Game {
    private final List<Player> players = new ArrayList<>();

    public synchronized void update(boolean isScore, boolean isLifeLost, Player player) {
        if (!player.isAlive()) return;

        if (isLifeLost) {
            player.loseLife();
        } else if (isScore) {
            player.updateScore();
        }

        if (!player.isAlive()) {
            System.out.println(player.getName() + " проиграл. Конец игры для него.");
        }
    }

    public synchronized void addPlayer(Player player) {
        players.add(player);
    }

    public synchronized void checkGameOver() {
        if (players.stream().noneMatch(Player::isAlive)) {
            printWin();
        }
    }

    private void printWin() {
        Optional<Player> winner = players.stream().max(Comparator.comparingInt(Player::getScore));
        System.out.println("----------------------------------------------------");
        winner.ifPresent(w -> System.out.println("ПОБЕДИЛ " + w.getName().toUpperCase() + "!!!  очки: " + w.getScore()));
    }
}
