package supercow;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss, int time) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(time);
        boss.leaveBattle(this);
    }
}
