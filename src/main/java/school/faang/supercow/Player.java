package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.printf("%s сражается с боссом...\n", name);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.printf("%s был прерван во время сражения\n", name);
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
