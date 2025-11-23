package school.faang.supercow;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Проект: god_bless
 * Класс Player
 * Автор: Vital
 */

@RequiredArgsConstructor
@Getter
public class Player {
    @NonNull
    private final String name;

    public void doBattle(@NonNull Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.println(name + " сражается с боссом...");
            Thread.sleep(2000); //имитация боя
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время сражения.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}