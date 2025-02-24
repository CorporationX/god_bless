package school.faang.sprint_3.task_43568;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private static final int SLEEP_TIME = 3000;

    private String name;

    public void fight(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван во время сна");
        }
        boss.leaveBattle(this);
    }
}
