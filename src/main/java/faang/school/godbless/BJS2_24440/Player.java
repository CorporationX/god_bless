package faang.school.godbless.BJS2_24440;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Player {
    private String name;
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        boss.battle(this);
        boss.leaveBattle(this);
    }
}
