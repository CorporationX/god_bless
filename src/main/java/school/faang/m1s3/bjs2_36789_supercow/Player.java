package school.faang.m1s3.bjs2_36789_supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void quitBattle(Boss boss) {
        if (boss.getCurrentPlayers().contains(this)) {
            synchronized (boss.getCurrentPlayers()) {
                System.out.println(name + " flees from the battlefield!");
                boss.getCurrentPlayers().remove(this);
                boss.getCurrentPlayers().notify();
            }
        }
    }
}
