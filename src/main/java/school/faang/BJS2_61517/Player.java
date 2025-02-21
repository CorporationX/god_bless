package school.faang.BJS2_61517;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@RequiredArgsConstructor
@Slf4j
public class Player {

    @NonNull
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("Идет бой...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }
}
