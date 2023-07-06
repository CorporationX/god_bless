package Sprint_4_Supercow;

import lombok.Data;

@Data
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }
    public void startJoiningBattle(Boss boss) {
        synchronized (boss) {
            boss.joinBattle(this);
        }
    }
    public void startLeavingBattle(Boss boss) {
        synchronized (boss) {
            boss.leaveBattle(this);
        }
    }
}
