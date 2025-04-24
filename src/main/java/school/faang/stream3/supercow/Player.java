package school.faang.stream3.supercow;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Random;

@ToString
@RequiredArgsConstructor
public class Player {
    private final String name;

    public Runnable doBattle(Boss boss) {
        return () -> {
            try {
                int staminaTime = new Random().nextInt(2000, 5000);
                boss.joinBattle(this);
                Thread.sleep(staminaTime);
                boss.leaveBattle(this);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
