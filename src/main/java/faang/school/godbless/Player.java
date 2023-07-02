package faang.school.godbless;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            System.out.println(name + " fighting with boss");
            Thread.sleep(3000);
            boss.endBattle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
