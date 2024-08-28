package faang.school.godbless.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {

    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
