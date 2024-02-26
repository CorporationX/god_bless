package faang.school.godbless.r_edzie.synchronization.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
public class Player extends Thread {
    @Getter
    private String nickname;
    private Boss boss;
    private final Random random = new Random();

    @Override
    public void run() {
        try {
            boss.joinBattle(this);
            Thread.sleep(random.nextInt(2000));
            boss.endBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
