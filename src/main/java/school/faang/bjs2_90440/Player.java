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
            System.out.printf("Игрок %s на потоке %s начал битву.%n", Thread.currentThread().getName(), name);
            Thread.sleep(8000);
            System.out.printf("Игрок %s на потоке %s завершил свою битву.%n",
                    Thread.currentThread().getName(), name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedException("Ожидание прервалось.");
        } finally {
            boss.leaveBattle(this);
        }
    }
}

