package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@ToString
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        Player player = new Player(name);
        boss.joinBattle(player);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("The thread was interrupted", e);
        }
        boss.leaveBattle(player);
    }
}
