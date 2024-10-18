package school.faang.BJS236776;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;


    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(3000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
