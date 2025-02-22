package school.faang.task_61539;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.println(name + " сражается с боссом...");
            Thread.sleep(5000); // Имитируем время боя
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время сражения.");
            Thread.currentThread().interrupt(); // Восстанавливаем флаг прерывания
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
