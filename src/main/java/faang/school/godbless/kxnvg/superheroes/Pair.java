package faang.school.godbless.kxnvg.superheroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair<S, S1> {

    private Superhero hero1;
    private Superhero hero2;

    public Superhero fight() {
        int hero1Points = hero1.getStrength() * 5 + hero1.getAgility() * 3;
        int hero2Points = hero2.getStrength() * 5 + hero2.getAgility() * 3;

        if (hero1Points > hero2Points) {
            return hero1;
        } else if (hero2Points > hero1Points) {
            return hero2;
        } else {
            if (Math.random() > 0.5) {
                return hero1;
            } else {
                return hero2;
            }
        }
    }
}
