package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
