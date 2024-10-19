package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);

        Thread.sleep(300);

        boss.leaveBattle(this);
    }

}
