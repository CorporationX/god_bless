package faang.school.godbless.bjs2_24361;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
        boss.leaveBattle(this);
    }
}
