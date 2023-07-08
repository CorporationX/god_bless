package faang.school.godbless.Multithreading.SynchronizationWaitNotify.task04_SuperCow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);

        Thread.sleep(1000);

        boss.endBattle();
    }
}
