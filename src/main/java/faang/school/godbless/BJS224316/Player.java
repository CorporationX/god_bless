package faang.school.godbless.BJS224316;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        Object lock = boss.getLock();
        synchronized (lock){
            System.out.println(lock);
            boss.joinBattle(this);
            Thread.sleep((long) (Math.random() * 10));
            boss.getCurrentPlayers().remove(this);
            lock.notify();
        }
    }
}
