package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player implements Runnable {
    private final String name;
    private final Boss boss;

    @Override
    public void run() {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted during the battle.");
        } finally {
            boss.leaveBattle(this);
        }
    }
}

