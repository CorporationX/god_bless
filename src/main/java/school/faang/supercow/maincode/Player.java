package school.faang.supercow.maincode;

import lombok.Getter;

@Getter
public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        try {
            boss.joinPlayer(this);

            Thread.sleep(2000);

            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
