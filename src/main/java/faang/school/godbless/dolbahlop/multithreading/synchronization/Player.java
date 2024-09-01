package faang.school.godbless.dolbahlop.multithreading.synchronization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        boss.battleProcess(this);
    }
}
