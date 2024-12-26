package school.faang.sprint_3.task_49712;

import lombok.Getter;

import java.util.Random;

@Getter
public class Player {
    private static int count = 0;
    private final String name;

    private final Random random = new Random();

    public Player() {
        name = "Player" + ++count;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        fight();
        boss.leaveBattle(this);
    }

    private void fight() {
        try {
            Thread.sleep(random.nextInt(1000, 8001));
        } catch (InterruptedException e) {
            System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
        }
    }
}
