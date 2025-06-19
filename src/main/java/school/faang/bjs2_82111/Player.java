package school.faang.bjs2_82111;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class Player {
    private final long id;
    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        TimeUnit.SECONDS.sleep(5);
        boss.leaveBattle(this);
    }
}
