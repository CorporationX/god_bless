package school.faang.broforce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
    private final Object score = new Object();
    private final  Object lives = new Object();
    private Integer scoreCounter;
    private Integer livesCounter;

    public void update(boolean playerScores, boolean playerLostLive) {
        if (playerLostLive){
            synchronized (lives){
                livesCounter--;
                System.out.println("Player lost life");
            }
        }

        if (playerScores){
            synchronized (score){
                scoreCounter++;
                System.out.println("Player scored");
            }

            if (livesCounter == 0){
                gameOver();
            }
        }
    }

    private void gameOver(){
        System.out.println("Game over.");
    }
}
