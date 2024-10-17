package school.faangSprint3.t07;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player implements Runnable {
    private String name;
    private Boss boss;

    public void startBattle() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            boss.joinBattle(this);

            Thread.sleep((long) (Math.random() * 5000));

            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время сражения!");
        }
    }
}