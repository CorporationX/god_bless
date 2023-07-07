package faang.school.godbless.multithreading.superheroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Superhero {
    private String name;
    private int strength;
    private int agility;

    public int getTotalPower() {
        return strength + agility;
    }
}
