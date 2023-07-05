package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void exitBattle(Boss boss){
        boss.deleteBattle(this);
    }
}
