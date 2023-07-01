package faang.school.godbless.Supercow;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Player {

    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);

        System.out.println(name + " Начал битву с боссом");
    }

    public void finishBattle(Boss boss) {
        boss.leaveBattle(this);
        System.out.println(name + " Завершил битву с боссом");
    }
}
