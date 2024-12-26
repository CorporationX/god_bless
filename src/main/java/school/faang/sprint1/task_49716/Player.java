package school.faang.sprint1.task_49716;

import lombok.Getter;

@Getter
public class Player {
    private final int delay = 2000;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public synchronized void startBattle(Boss boss)  {
        try {
            boss.joinBattle(this);
            Thread.sleep(delay);
            boss.leaveBoss(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
