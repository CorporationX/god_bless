package faang.school.godbless.BJS2_24204;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Player {
    @Getter
    private final String name;
    @Getter
    private int lives = 3;
    @Getter
    @Setter
    private boolean isLostOneLives = false;
    @Getter
    @Setter
    private boolean isGetNewPoint = false;
    private final Game game;


    public void minusLive() {
        isLostOneLives = true;
        lives--;
        game.update(this);
    }

    public void plusPoint() {
        isGetNewPoint = true;
        game.update(this);
    }
}
