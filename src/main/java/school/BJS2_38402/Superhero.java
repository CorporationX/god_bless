package school.BJS2_38402;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Superhero {
    @Getter
    private String name;
    private int strength;
    private int agility;

    private int sumOfStrengthAndAgility() {
        return strength + agility;
    }

    public Superhero battleSuperheroes(Superhero superhero) {
        return sumOfStrengthAndAgility() >= superhero.sumOfStrengthAndAgility() ? this : superhero;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "name='" + name + '\'' +
                '}';
    }
}
