package school.faang.BJS2_61522;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void leaveBattle() {
    }
}
