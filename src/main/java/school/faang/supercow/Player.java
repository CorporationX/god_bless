package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;

    public synchronized void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(3000);
        boss.leaveBattle(this);
    }
}