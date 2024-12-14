package faang.school.godbless.BJS2_7907;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Battlefield {
  private Hero firstHero;
  private Hero secondHero;

  public String battle() {
    int sumFirstDamage = getAllHeroDamage(firstHero);
    int sumSecondProtection = getAllHeroProtection(secondHero);

    if (sumFirstDamage >= sumSecondProtection) {
      return "Первый игрок победил";
    } else {
      return "Второй игрок победил";
    }
  }

  private int getAllHeroDamage(Hero hero) {
    Optional<Integer> allDamage = firstHero.getArmy().stream().map(c -> c.getDamage() * c.getQuantity()).reduce(Integer::sum);
    return allDamage.orElse(0);
  }

  private int getAllHeroProtection(Hero hero) {
    Optional<Integer> allProtection = hero.getArmy().stream().map(c -> c.getProtection() * c.getQuantity()).reduce(Integer::sum);
    return allProtection.orElse(0);
  }
}
