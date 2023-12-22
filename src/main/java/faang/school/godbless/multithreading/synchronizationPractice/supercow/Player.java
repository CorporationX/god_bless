package faang.school.godbless.multithreading.synchronizationPractice.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(5_000);
        boss.endBattle(this);
    }
}
