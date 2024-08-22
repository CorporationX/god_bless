package faang.school.godbless.sprint3.supercow;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        System.out.printf("Игрок %s присоединился к бою%n", name);
        Thread.sleep(new Random().nextInt(1, 9) * 1000L);
        System.out.printf("Игрок %s вышел из боя%n", name);
        boss.exitBattle(this);
    }
}
