package faang.school.godbless.fourthsprint.superheroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public class Superhero {
    private String name;
    private int strength;
    private int agility;

    @Override
    public String toString() {
        return name;
    }
}
