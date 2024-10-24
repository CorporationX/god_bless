package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        Player player = new Player(name);
        boss.joinBattle(player);
        Thread.sleep(2000);
        boss.finishedFight(player);
    }
}
