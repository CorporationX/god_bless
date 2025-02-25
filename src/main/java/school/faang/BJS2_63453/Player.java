package school.faang.BJS2_63453;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Slf4j
public class Player implements Runnable {
    private final String name;
    private final Boss boss;

    @Override
    public void run() {
        doBattle(boss);
    }

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            System.out.printf("🔥 %s сражается с боссом...%n", name);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            log.error("Бой с боссом не закончен ", e);
        }
    }


}
