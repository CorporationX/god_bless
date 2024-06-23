package faang.school.godbless.supercow;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    public void startBattle(Boss boss) throws InterruptedException {
            boss.joinBattle(this);
            Thread.sleep(500);
            boss.removePlayer(this);
    }
}
