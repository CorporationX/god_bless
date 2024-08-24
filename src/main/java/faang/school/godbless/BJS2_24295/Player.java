package faang.school.godbless.BJS2_24295;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Player {

    private final String name;
    private boolean isJoined = false;

    public void startBattle(Boss boss) {
        System.out.println("Player " + name + " want to join the battle");
        boss.joinBattle(this);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (isJoined) {
            boss.leaveBattle(this);
        }
    }
}
