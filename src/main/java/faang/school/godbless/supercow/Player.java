package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            battle();
            boss.endBattle();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " прервалось присоединение");
        }
    }

    private void battle() throws InterruptedException {
        System.out.println(name + " сражается с боссом");
        Thread.sleep((long) (Math.random() * 5000));
        System.out.println(name + " завершил сражение");
    }
}
