package faang.school.godbless.Supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boss.finishBattle(this);
    }
}
