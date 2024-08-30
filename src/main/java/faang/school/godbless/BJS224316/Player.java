package faang.school.godbless.BJS224316;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        synchronized (this) {
            System.out.println(this);
            boss.joinBattle(this);
            Thread.sleep((long) (Math.random() * 10));
            boss.removePlayer(this);
            this.notify();
        }
    }
}
