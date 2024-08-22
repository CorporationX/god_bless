package faang.school.godbless.BJS2_24190;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {

    private String name;
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println(name + " сражается с боссом");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            return;
        }
        System.out.println(name + " победил босса");
        boss.finishedBattle(this);
    }

}
