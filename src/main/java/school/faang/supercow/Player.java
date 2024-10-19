package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        System.out.println("Palyer " + name + " tries to join the battle");
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Start Battle - sleep is interrupted");
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        boss.finishBattle(this);
    }
}
