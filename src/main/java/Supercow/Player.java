package Supercow;

import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public void startBattle(Boss boss){
        boss.joinBattle(this);
    }

    public Player(String name) {
        this.name = name;
    }
}
