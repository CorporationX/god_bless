package school.faang.bjs249633;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static final double CHANCE_EARN_POINTS = 0.5;
    public static final double CHANCE_LOSE_LIFE = 0.7;
    public static final int DELAY_GAME_STEP = 100;
    public static final int CYCLE_GAME = 100;

    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < CYCLE_GAME; i++) {
            boolean isEarnedPoints = Math.random() > CHANCE_EARN_POINTS;
            boolean isLostLife = Math.random() > CHANCE_LOSE_LIFE;

            boolean liveStatus = game.update(isEarnedPoints, isLostLife);
            if (!liveStatus) {
                break;
            }

            try {
                Thread.sleep(DELAY_GAME_STEP);
            } catch (InterruptedException ex) {
                log.error("Error interrupted exception!! {}", String.valueOf(ex));
            }
        }
    }
}
