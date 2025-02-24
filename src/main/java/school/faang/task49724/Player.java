package school.faang.task49724;

import lombok.Data;

@Data
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(1500);
        boss.getOutBattle(this);
    }
}
