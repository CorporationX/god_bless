package school.faang.sprint_1.task_supercowbjs2n49687;

import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        System.out.printf("%s wants to join battle -> ", this.name);
        boss.joinBattle(this);
    }

}
