package school.faang.task_61580;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Player {
    private static final int BATTLE_DURATION = 5_000;

    @NonNull
    private final String name;

    public void doBattle(@NonNull Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(BATTLE_DURATION);
        } catch (InterruptedException e) {
            System.out.printf("%s: битва прервана%n", name);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
