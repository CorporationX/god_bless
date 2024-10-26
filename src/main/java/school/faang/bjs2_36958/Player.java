package school.faang.bjs2_36958;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@ToString
public class Player {
    private String name;

    public void startBattle(@NonNull Boss boss) {
        boss.joinBattle(this);
    }

    public void participateInBattle(Boss boss) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
