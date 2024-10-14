package school.faang.armyOfHeroes.army;

import lombok.Getter;
import school.faang.armyOfHeroes.heroes.Hero;

import java.util.List;

public class PowerCalculator implements Runnable {
  private final List<Hero> heroes;
  @Getter
  private int totalPower = 0;

  PowerCalculator(List<Hero> heroes){
    this.heroes = heroes;
  }
  @Override
  public void run() {
    for(Hero hero : heroes){
      totalPower += hero.getPower();
    }

    System.out.printf("сила всех %s -> %d\n", heroes.get(0).getClass().getSimpleName(), totalPower);
  }
}
