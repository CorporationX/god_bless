package faang.school.godbless.Sprint_4.Multithreading_Synchronization.Supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private boolean isFightying;

    public void startBattle(Boss boss) {
        if (isFightying == false) {
            try {
                boss.joinBattle(this);
                isFightying = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else System.out.println("Already!");
    }

    public void endBattle(Boss boss) {
        if (isFightying == true) {
            try {
                boss.leaveBattle(this);
                isFightying = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else System.out.println("No fkng fighting!");
    }
}
