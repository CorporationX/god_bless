package school.faang.bjs2_90446;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    public static final int THREAD_SLEAP = 100;
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.println(name + " сражается с боссом...");
            Thread.sleep(THREAD_SLEAP);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время сражения.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
