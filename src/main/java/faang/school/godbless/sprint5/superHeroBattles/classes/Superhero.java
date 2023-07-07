package faang.school.godbless.sprint5.superHeroBattles.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter
public class Superhero {
    private String name;
    private int strength;
    private int agility;

    @SneakyThrows
    public static Superhero getStrongestHero(Superhero firstHero, Superhero secondHero) {
        Thread.sleep(20);
        if (firstHero.agility + firstHero.strength > secondHero.agility + secondHero.strength) {
            return firstHero;
        } else {
            return secondHero;
        }
    }
}
