package school.faang.task_49801;

import lombok.Getter;

@Getter
public class Player {
    private String name;

    public Player(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Field name cannot be empty");
        }
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
