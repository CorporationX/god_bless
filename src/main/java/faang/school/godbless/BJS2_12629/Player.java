package faang.school.godbless.BJS2_12629;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Player {
    private String name;

    public void startBattle(Boss boss){
        try {
            boss.joinBattle(this);
            Thread.sleep(4000);
            boss.endPlaying(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
