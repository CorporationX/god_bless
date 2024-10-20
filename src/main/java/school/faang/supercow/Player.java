package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Player {
    static Random random = new Random();
    private String name;
    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        System.out.println(getName() + " нанёс " + random.nextInt(0, 100) + " урона.");
        Thread.sleep(5000);
        boss.leaveBattle(this);
    }
}
