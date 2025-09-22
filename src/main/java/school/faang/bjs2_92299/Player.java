package school.faang.bjs2_92299;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.printf("Player %s was interrupted\n", this);
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
