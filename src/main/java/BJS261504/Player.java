package BJS261504;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private static final Integer BATTLE_TIMEMS = 2000;
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(BATTLE_TIMEMS);
        } catch (InterruptedException e) {
            System.out.println(name + " stop the battle ");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
