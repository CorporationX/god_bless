package faang.school.godbless.synchronization.sypercow;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private final Long TIME_ATTACK = 1000L;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(TIME_ATTACK);
        } catch (InterruptedException e) {
            System.out.println(String.format("Player:%s disconnect!", this.name));
        }
        boss.leaveBattle(this);
    }
}
