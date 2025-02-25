package school.faang.BJS2_61522;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Player {
    private static final long BATTLE_TIME = 5000;
    private final String name;

    public void doBattle(@NonNull Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            log.error(SupercowMessages.SOMETHING_WENT_WRONG, e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
