package mod1sp3.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Sleep method error " + e.getMessage(), e);
        }
        boss.leaveBattle(this);
    }
}
