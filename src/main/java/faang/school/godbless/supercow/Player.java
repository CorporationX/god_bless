package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        System.out.println("Бой " + this.getName() + " c Boss начался");
        Thread.sleep(10000);
        boss.endBattle(this);
    }
}