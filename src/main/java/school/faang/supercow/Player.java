package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Data
@AllArgsConstructor
public class Player {
    static Random random = new Random();
    private String name;
    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        System.out.println(getName() + " нанёс " + random.nextInt(0, 100) + " урона.");
        log.info("Был нанесен урон.");
        Thread.sleep(5000);
        boss.leaveBattle(this);
    }
}
