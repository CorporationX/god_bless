package school.faang.task_61614;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.printf("%s сражается с боссом%n", this.getName());
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("%s был прерван во время сражения. %s",
                    this.getName(), e.getMessage());
        } finally {
            boss.leaveBattle(this);
        }
    }
}
