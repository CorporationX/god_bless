package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println(getName() + " начал битву");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boss.finishBattle();
        System.out.println(getName() + " закончил битву");

    }
}
