package broForce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Game game, boolean isPointEarned, boolean isLifeLost) {
        System.out.printf("Player %s is battling.\n", name);
        game.update(this, isPointEarned, isLifeLost);
    }
}
