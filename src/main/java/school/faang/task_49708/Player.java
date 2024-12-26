package school.faang.task_49708;

import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep((long) (Math.random() * 3000) + 2000);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время сражения.");
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
