package school.faang.task_49696;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println("killing boss.. " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }
}