package faang.school.godbless.ThirdSprint.BJS2_26037;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Getter
public class Player {
    @NonNull
    private String name;
    private Boss boss;
    private int battleTime = ThreadLocalRandom.current().nextInt(1, 5) * 1000;

    public void startBattle(Boss boss) {
        this.boss = boss;
        try {
            boss.joinBattle(this);
            Thread.sleep(battleTime);
            System.out.println(getName() + " отважно бился " + battleTime / 1000 + " секунд");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        endBattle(this);
    }

    public void endBattle(Player player) {
        synchronized (boss) {
            System.out.println(Thread.currentThread().getName());
            boss.currentPlayers.remove(player);
            System.out.println(player.getName() + " покинул битву");
            boss.notify();
        }
    }
}
