package bjs2_36830;

import lombok.Getter;

public class Player {
    @Getter
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
    }
}
