package faang.school.godbless.modul3.supercow;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(3000);
            boss.endPlaying(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
