package faang.school.godbless.BJS2_13089;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Player {
    private final String name;
    @Getter @Setter
    private int lives = 10;
    @Getter @Setter
    private boolean isAlive = true;

    public Player(String name) {
        this.name = name;
    }

    public void decreaseLives() {
        this.lives--;
        if (this.lives == 0) {
            this.isAlive = false;
        }
    }

    public void makeAttack(Game game) throws InterruptedException {
        Thread.sleep(100);
        Player enemy = findEnemy(game);
        game.increaseScores();
        game.increaseLives();
        enemy.decreaseLives();
        System.out.println("Player " + this.name + " is attacking " + enemy.name);
    }

    private Player findEnemy(Game game) {
        return game.getPlayers().stream()
                .filter(p -> !p.equals(this) && p.isAlive())
                .toList()
                .get(Randomizer.RAND.nextInt(0, game.getPlayers().size() - 1));
    }
}
