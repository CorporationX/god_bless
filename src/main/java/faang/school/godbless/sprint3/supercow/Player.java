package faang.school.godbless.sprint3.supercow;

import lombok.ToString;

@ToString
public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinPlayer(this);
        boss.endBattle(this);
    }

    public String getName() {
        return name;
    }

}
