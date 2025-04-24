package school.faang.bjs273463;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(name + " вызвал InterruptedException");
        } finally {
            boss.leaveBattle(this);
        }
    }
}
