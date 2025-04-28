package school.faang.bjs273463;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private static final int TIMEOUT_MILLIS = 3000;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(TIMEOUT_MILLIS);
        } catch (InterruptedException e) {
            System.out.println(name + " вызвал InterruptedException");
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
