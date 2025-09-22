package school.faang.bjs2_92299;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(500);
        boss.leaveBattle(this);
    }
}
