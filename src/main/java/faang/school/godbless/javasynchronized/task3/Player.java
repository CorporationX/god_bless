package faang.school.godbless.javasynchronized.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
        } catch (InterruptedException e) {
            System.out.println("Завершение");
        }
    }
}
