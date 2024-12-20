package school.faang.task_49664;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        System.out.println(name + " сражается с боссом...");
        Thread.sleep(2000);
        boss.leaveBattle(this);
    }
}
