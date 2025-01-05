package school.faang.task_49834;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private final Object lock = new Object();
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(2000);
        boss.leaveBattle(this);
    }
}
