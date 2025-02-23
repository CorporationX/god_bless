package school.faang.supercow;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@ToString
@Getter
public class Player {
    private static final int FIVE_SECONDS = 5000;

    @NonNull
    private final String name;

    public void doBattle(@NonNull Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        try {
            log.info("Игрок {} сражается с боссом...", name);
            Thread.sleep(FIVE_SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Бой игрока {} прерван", name);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
