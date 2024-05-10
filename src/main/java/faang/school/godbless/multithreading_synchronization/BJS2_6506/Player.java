package faang.school.godbless.multithreading_synchronization.BJS2_6506;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
@Getter
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(new Random().nextInt(5000));
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted during the battle. " + e);
        }
    }
}
