package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        System.out.println(name + " is attempting to start the battle");
        boss.joinBattle(this);
    }
}
