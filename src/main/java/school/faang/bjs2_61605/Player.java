package school.faang.bjs2_61605;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            System.out.println("Бой в самом разгаре!");
            Thread.sleep(2000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
