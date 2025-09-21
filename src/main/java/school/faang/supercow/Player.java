package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player implements Runnable {

    private String name;
    private Boss boss;

    private void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            System.out.println(name + " is fighting!");
            Thread.sleep(500); // бой длится полсекунды
            boss.leaveBattle(this);
            System.out.println(name + " finished fighting!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        doBattle(boss);
    }
}
