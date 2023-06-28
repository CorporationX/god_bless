package faang.school.godbless.superCow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
@Getter
@AllArgsConstructor
public class Player {
    @NonNull
    private String name;

    public void startBattle(Boss boss){
        boss.joinBattle(this);
    }

    public void leaveBattle(Boss boss){
        boss.leaveBattle(this);
    }
}
