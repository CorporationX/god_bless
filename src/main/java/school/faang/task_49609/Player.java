package school.faang.task_49609;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class Player {
    private final String name;

    public Player(String name) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("playerName");
        }

        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Произошла ошибка");
        }
        boss.leaveBattle(this);
    }
}
