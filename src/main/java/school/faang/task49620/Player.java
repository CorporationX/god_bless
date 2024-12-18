package school.faang.task49620;

import java.util.Objects;

public record Player(String name) {
    public void startBattle(Boss boss) {
        Objects.requireNonNull(boss);
        boss.joinBattle(this);
    }
}
