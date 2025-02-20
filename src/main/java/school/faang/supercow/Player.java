package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);

        try {
            log.info("{} сражается с боссом!", name);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("{} был прирван во время ожидание", name);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}