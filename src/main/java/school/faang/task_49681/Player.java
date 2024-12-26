package school.faang.task_49681;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void finishBattle(Boss boss) {
        boss.exitBattle(this);
    }
}
