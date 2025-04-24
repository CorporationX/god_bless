package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class Player {

    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("Ошибка в потоках", e);
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }

}
