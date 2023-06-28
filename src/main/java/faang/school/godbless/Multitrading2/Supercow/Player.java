package faang.school.godbless.Multitrading2.Supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss){
        boss.joinBattle(this);
        try {
            Thread.sleep(1000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
