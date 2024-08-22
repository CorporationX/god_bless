package faang.school.godbless.BJS2_24179;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(new Random().nextInt(5000, 10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        endBattle(boss);
    }

    public void endBattle(Boss boss) {
        boss.exitBattle(this);
    }
}
