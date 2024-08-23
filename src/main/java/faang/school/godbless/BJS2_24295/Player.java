package faang.school.godbless.BJS2_24295;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {

    private final String name;

    public void startBattle(Boss boss) {
        System.out.println("Player " + name + " want to join the battle");
        boss.joinBattle(this);
    }
}
