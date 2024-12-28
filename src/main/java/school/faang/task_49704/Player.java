package school.faang.task_49704;

import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(2000);
        boss.completionOfTheBattle(this);
    }
}
