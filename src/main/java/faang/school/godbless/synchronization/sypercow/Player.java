package faang.school.godbless.synchronization.sypercow;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private final Long TIME_ATTACK = 1000L;

    public void startBattle(Boss boss) {
        System.out.println(String.format("Player:%s begin attacked boss!", this.name));
        boss.joinBattle(this);
        try {
            Thread.sleep(TIME_ATTACK);
        } catch (InterruptedException e) {
            System.out.println(String.format("Player:%s disconnect!", this.name));
        }
        System.out.println(String.format("Player:%s leaves the battle!", this.name));
        boss.leaveBattle(this);
    }
}
