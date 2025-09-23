package school.faang.bjs2_90325;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;

    public void doBattle(Boss boss) throws InterruptedException {
        try {
            boss.joinBattle(this);

            System.out.printf("%s начинает сражение!%n", name);
            Thread.sleep((int) (Math.random() * 5000));
            System.out.printf("%s завершил сражение!%n", name);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("%s был прерван во время боя%n", name);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
