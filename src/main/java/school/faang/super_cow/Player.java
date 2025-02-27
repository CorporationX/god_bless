package school.faang.super_cow;

import lombok.Getter;

@Getter
public class Player {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        boss.leaveBattle(this);
    }
}
