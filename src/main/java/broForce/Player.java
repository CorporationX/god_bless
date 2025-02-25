package broForce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Game game, boolean isPointEarned, boolean isLifeLost) {
        game.update(this, isPointEarned, isLifeLost);
    }
}
