package school.faang.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.printf("%s battle", name);
            System.out.println();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
