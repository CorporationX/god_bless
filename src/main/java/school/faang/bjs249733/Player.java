package school.faang.bjs249733;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Player {

    @Getter
    private String name;

    public void startBattle(Boss boss, long time) {
        boss.joinBattle(this);
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boss.leaveBattle(this);
    }

}
