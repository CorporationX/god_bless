package faang.school.godbless.sprint3.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
    }
}
