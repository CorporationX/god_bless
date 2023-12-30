package faang.school.godbless.Supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss, Player player) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(3000);
        boss.endBattle(player);
    }
}
