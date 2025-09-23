package school.faang.bjs2_90336;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} сражается с боссом...", name);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("{} был прерван во время сражения.", name);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
