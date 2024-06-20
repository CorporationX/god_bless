package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("%s: Starting game failed for player: %s", e.getMessage(), this.name));
        }
        boss.finishBattle(this);
    }
}
