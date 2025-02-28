package school.faang.BJS2_61598;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Player {
    private static final int BATTLE_DURATION = 1000;
    @Getter
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.printf("%s начал сражение с %s!\n", name, boss.getName());
            Thread.sleep(BATTLE_DURATION);
        } catch (InterruptedException e) {
            System.err.println(name + " был вынужден прекратить бой.");
            return;
        }
        boss.leaveBattle(this);
    }
}
