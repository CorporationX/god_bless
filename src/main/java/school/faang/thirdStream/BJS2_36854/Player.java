package school.faang.thirdStream.BJS2_36854;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println("Идет сражение");

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            System.out.println("В ходе сражения что-то пошло не так");
            e.printStackTrace();
        }

        boss.leaveBattle(this);
    }
}
