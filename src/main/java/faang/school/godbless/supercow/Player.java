package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        if (!boss.getCurPlayers().contains(this)){//если вдруг игрок уже в лобби,
            // то ему остается только начать бойню
            boss.joinBattle(this);
        }
        System.out.println(name + " start battle with boss");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " end battle with boss");
    }
}
