package faang.school.godbless.fourthsprint.superheroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Superhero {
    @Getter
    private String name;
    private int strength;
    private int agility;

    public int getPower() {
        return strength + agility;
    }

    @Override
    public String toString() {
        return name;
    }
}
