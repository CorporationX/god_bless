package bjs2_35742;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
    }

    public void leaveBattle(Boss boss) {
        boss.leaveBattle(this);
    }
}
