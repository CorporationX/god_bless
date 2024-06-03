package faang.school.godbless.BJS2_5839;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public  void stopFight(Boss boss) {
        boss.fightWithBoss(this);
    }
}
