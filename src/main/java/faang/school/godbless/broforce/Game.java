package faang.school.godbless.broforce;

public class Game {
    private int score;
    private int loseLives;

    public Game() {
        this.score = 0;
        this.loseLives = 0;
    }

    public synchronized void update(BroForceEntity entity) {
        entity.setLives(entity.getLives() - 1);
        if (entity.getType() == InGameType.ENEMY && entity.getLives() == 0) {
            score++;
        } else if (entity.getType() == InGameType.PLAYER && entity.getLives() == 0) {
            gameOver(entity);
        }
    }

    private void gameOver(BroForceEntity entity) {
        System.out.println("GAME OVER");
        System.out.println(entity.getName() + " died");
    }
}
