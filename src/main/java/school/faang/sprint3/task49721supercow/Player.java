package school.faang.sprint3.task49721supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Player implements Runnable {
    private final String name;
    private Boss boss;

    public void startBattle() throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(500);
        boss.leaveBattle(this);
    }

    @Override
    public void run() {
        try {
            startBattle();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
