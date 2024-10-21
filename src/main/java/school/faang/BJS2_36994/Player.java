package school.faang.BJS2_36994;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player implements Runnable {
    private final String name;
    private final Boss boss;

    @Override
    public void run() {
        startBattle();
    }

    public void startBattle() {
        boss.joinBattle(this);
        try {
            System.out.println(name + " сражение с боссом...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(name + " победил босса!");
            boss.leaveBattle(this);
        }
    }

}
