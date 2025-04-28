package school.faang.bjs273466;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Battle interrupted");
        }
        boss.leaveBattle(this);
    }
}
