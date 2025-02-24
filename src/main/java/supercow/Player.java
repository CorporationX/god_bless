package supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.printf("Player %s is battling the boss.%n", name);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Player {} was interrupted during the battle.", name, e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
