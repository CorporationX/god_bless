package school.BJS2_38402;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Superhero implements Comparable<Superhero> {

    private String name;
    private int strength;
    private int agility;

    private int sumOfStrengthAndAgility() {
        return strength + agility;
    }

    @Override
    public int compareTo(Superhero o) {
        return sumOfStrengthAndAgility() - o.sumOfStrengthAndAgility();
    }
}
