package faang.school.godbless.synchronize.superCow;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            System.out.println(name + " has joined the battle");
            TimeUnit.SECONDS.sleep(5);
            boss.finishBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
