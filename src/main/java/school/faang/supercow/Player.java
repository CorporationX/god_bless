package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void battle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(100);
        boss.leaveBattle(this);
    }
}
