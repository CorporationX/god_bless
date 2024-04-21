package faang.school.godbless.Supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Player {
    private final String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(2000);
            boss.finishBattle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
