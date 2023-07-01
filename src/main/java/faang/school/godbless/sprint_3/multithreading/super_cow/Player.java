package faang.school.godbless.sprint_3.multithreading.super_cow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println("Сражение началось...");
        System.out.println("Сражение закончено!");
        boss.leaveFight();
    }
}
