package faang.school.godbless.kxnvg.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void deletePlayer(Boss boss) {
        boss.deletePlayer(this);
    }
}
