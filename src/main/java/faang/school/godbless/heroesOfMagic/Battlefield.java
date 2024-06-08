package faang.school.godbless.heroesOfMagic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Battlefield {

    private Hero firstHero;
    private Hero secondHero;

    public Hero battle() {
        int firstHeroSummaryDamage = firstHero.getArmy().stream()
                .mapToInt(Creature::getDamage)
                .sum();

        int secondHeroSummaryDamage = secondHero.getArmy()
                .stream()
                .mapToInt(Creature::getDamage)
                .sum();

        if (firstHeroSummaryDamage > secondHeroSummaryDamage) {
            return firstHero;
        } else if (firstHeroSummaryDamage < secondHeroSummaryDamage) {
            return secondHero;
        } else {
            return null;
        }
    }
}
