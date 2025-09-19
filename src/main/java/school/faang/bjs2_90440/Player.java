package school.faang.bjs2_90440;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        try {
            boss.joinBattle(this);
            System.out.printf("Игрок %s на потоке %s начал битву.%n", name, Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.printf("Игрок %s на потоке %s завершил свою битву.%n",
                    name, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedException("Ожидание прервалось.");
        } finally {
            boss.leaveBattle(this);
        }
    }
}

