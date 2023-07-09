package faang.school.godbless.sprint_3.multithreading.super_cow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    @SneakyThrows
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println("Сражение началось...");
        int waitTime = ThreadLocalRandom.current().nextInt(5) * 1000;
        Thread.sleep(waitTime);
        System.out.println("Сражение закончено!");
        boss.leaveFight();
    }
}
