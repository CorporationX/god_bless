package school.faang.bjs273515;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.println(name + " entering to boss fight...");
            Thread.sleep(21000);
        } catch (InterruptedException e) {
            System.out.println("Error while a battle");
            Thread.currentThread().interrupt();
        }
        boss.leaveBattle(this);
    }
}