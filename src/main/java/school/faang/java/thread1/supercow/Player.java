package school.faang.java.thread1.supercow;

import lombok.Data;
import school.faang.java.thread1.supercow.Boss;

@Data
public class Player {
    private final String name;

    public void startBattle(Boss boss){
        try {
            boss.joinBattle(this);
            Thread.sleep(300);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}