package school.faang.task_49728;

import lombok.Getter;

@Getter
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startButtle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(2000);
        boss.leaveBattle(this);
    }

}
