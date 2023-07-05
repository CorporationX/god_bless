package faang.school.godbless.superheroes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class Pair {
    private Superhero superhero1;
    private Superhero superhero2;

    public Superhero determineWinner() {
        if ((superhero1.getStrength() + superhero1.getAgility()) > (superhero2.getStrength() + superhero2.getAgility())) {
            return superhero1;
        } else if ((superhero1.getStrength() + superhero1.getAgility()) == (superhero2.getStrength() + superhero2.getAgility())) {
            if (new Random().nextInt(1, 2) == 1) {
                return superhero1;
            } else {
                return superhero2;
            }
        } else {
            return superhero2;
        }
    }
}
