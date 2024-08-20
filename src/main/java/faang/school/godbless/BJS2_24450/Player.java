package faang.school.godbless.BJS2_24450;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Player {
    private static Random rand = new Random();
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public long getBattleTime() {
        return rand.nextLong(1_000, 10_000);
    }
}
