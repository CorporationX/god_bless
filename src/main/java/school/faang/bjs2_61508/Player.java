package school.faang.bjs2_61508;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(2000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("{} was interrupted during battle!", name);
        }
    }
}
