package faang.school.godbless.sprint3.BJS2_6319;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(new Random().nextInt(5000) + 1000);
            boss.leaveBattle(this);
        } catch (InterruptedException exception) {
            System.out.println(name + " was interrupted during battle. " + exception);
        }
    }
}