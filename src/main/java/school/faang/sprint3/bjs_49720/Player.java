package school.faang.sprint3.bjs_49720;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private static final int DELAY = 3000;

    private final String name;

    public synchronized void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(DELAY);
        boss.leaveBattle(this);
    }
}
