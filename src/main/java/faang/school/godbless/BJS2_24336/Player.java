package faang.school.godbless.BJS2_24336;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        boss.processPlayerBattle(this);
    }
}
