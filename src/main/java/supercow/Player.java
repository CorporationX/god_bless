package supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(1000);
        boss.leaveBattle(this);
    }
}
