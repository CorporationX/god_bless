package faang.school.godbless.multithreading.synch.cow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            battle();
            boss.endBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void battle() throws InterruptedException {
        System.out.println(name + " fight with boss");
        Thread.sleep(1000);
        System.out.println(name + " fight ends");
    }
}
