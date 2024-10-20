package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {

    private String name;

    public void startBattle(Boss boss){
        boss.joinBattle(this);
        boss.endBattle(this);
        try {
            boss.wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
