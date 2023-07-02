package faang.school.godbless.synchronize.skyNet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Robot {
    private String name;
    private final Target target;

    public void attack() throws InterruptedException {
        System.out.println(name + " атакует цель " + target.getName());
        TimeUnit.SECONDS.sleep(1);
        synchronized (target) {
            target.setAttackCount(target.getAttackCount() + 1);
            System.out.println("Цель " + target.getName() + " попытались атаковать " + target.getAttackCount() + " раз(а)");
        }
    }
}
