package school.faang.BJS2_37202;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Unit {
    private String name;
    private int healthPoint;
    private Game game;

    public void earnPoint() {
        if (game.isGameOver()) return;
        int pointsEarned = 1;
        game.update(true, false);
        System.out.printf("%s - заработал: %d - очков\n", name, pointsEarned);
    }

    public void loseLife() {
        if (game.isGameOver()) return;

        if (healthPoint > 0) {
            healthPoint--;
            game.update(false, true);
            System.out.printf("%s потерял жизнь, осталось: %d \n", name, healthPoint);
            if (healthPoint == 0) {
                System.out.println(name + " больше не имеет жизней.");
            }
        }
    }
}
