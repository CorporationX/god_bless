package faang.school.godbless.BJS2_1149;

import lombok.Getter;

@Getter
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;

    }
    public void startBattle(Boss boss)  {
        try {
            boss.joinBattle(this);
        } catch (InterruptedException e) {
            System.out.println("Starting of battle failed");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleep after starting battle");
        }

        try {
                boss.completeBattle(this);
            } catch (InterruptedException e) {
                System.out.println("Fail in end of battle");
            }

    }
}
