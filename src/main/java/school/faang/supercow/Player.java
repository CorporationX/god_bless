package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss){
        try {
            boss.joinBattle(this);
            Thread.sleep(2000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}