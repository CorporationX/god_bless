package school.faang.task_49628;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(@NonNull String name) {
    public Player {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    public void startBattle(@NonNull Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
        }
        boss.leaveBattle(this);
    }

}
