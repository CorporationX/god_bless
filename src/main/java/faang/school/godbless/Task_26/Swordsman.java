package faang.school.godbless.Task_26;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class Swordsman {

    static final Object LOCK = new Object();
    static final int DAMAGE = 1;
    int xp;
    int score;
    String name;

    void hit(Swordsman character, Game game) {
        synchronized (LOCK) {
            if (character.getXp() != 0 && getXp() != 0) {
                System.out.println(getName() + " is damaging " + character.getName());
                character.setXp(character.getXp() - DAMAGE);
                game.update();
                if (character.getXp() == 0) {
                    System.out.println("Character " + character.getName() + " died");
                }
                upScore();
            }
        }
    }

    private void upScore() {
        score++;
        System.out.println("Xp of " + getName() + " = " + getXp());
    }
}
