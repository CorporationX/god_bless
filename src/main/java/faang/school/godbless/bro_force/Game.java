package faang.school.godbless.bro_force;

import lombok.Getter;

@Getter
public class Game {
    private int score = 0;
    private int lives = 0;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private volatile boolean isSomeoneDead = false;


    public UpdateResult update(Player player) {
        System.out.println(player);
        if (isSomeoneDead) {
            Thread.currentThread().interrupt();
            return UpdateResult.GAME_OVER;
        }

        boolean playerFightingSuccess = player.isFightSuccessful();

        if (playerFightingSuccess) {
            return handleSuccessfulFight(player);
        } else {
            return handleUnsuccessfulFight(player);
        }
    }

    private UpdateResult handleSuccessfulFight(Player player) {
        synchronized (scoreLock) {
            if (!isSomeoneDead) {
                player.incrementScore();
                score++;
                System.out.println(player.getPlayerName() + " earned one point");
                return UpdateResult.SUCCESS;
            } else {
                Thread.currentThread().interrupt();
                return UpdateResult.GAME_OVER;
            }
        }
    }

    private UpdateResult handleUnsuccessfulFight(Player player) {
        synchronized (livesLock) {
            if (!isSomeoneDead) {
                player.decrementLives();
                lives++;
                System.out.println(player.getPlayerName() + " lost his life");
                if (!player.isAlive()) {
                    isSomeoneDead = true;
                    gameOver();
                    return UpdateResult.GAME_OVER;
                }
                return UpdateResult.FAILURE;
            } else {
                Thread.currentThread().interrupt();

                return UpdateResult.GAME_OVER;
            }
        }
    }

    private void gameOver() {
        System.out.println("Game is Over. Final Score: " + score);
        Thread.currentThread().interrupt();
    }
}
