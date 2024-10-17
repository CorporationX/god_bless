package school.faang.armyOfHeroes.army;

import school.faang.armyOfHeroes.heroes.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Army {
  private final Map<String, List<Hero>> heroes = new HashMap<>();
  private final Set<Hero> noRepetitionsHeroes = new HashSet<>();

  public void addHero(Hero hero) {
    if (!noRepetitionsHeroes.contains(hero)) {
      noRepetitionsHeroes.add(hero);
      heroes.computeIfAbsent(hero.getClass().getSimpleName(), k -> new ArrayList<>()).add(hero);
    }
  }

  public int calculateTotalPower() throws InterruptedException {
    int totalPower = 0;

    List<Thread> threads = new ArrayList<>();
    List<PowerCalculator> powerCalculators = new ArrayList<>();

    heroes.forEach((key, value) -> {
      PowerCalculator powerCalculator = new PowerCalculator(value);
      Thread thread = new Thread(powerCalculator);

      powerCalculators.add(powerCalculator);
      threads.add(thread);
      thread.start();
    });

    for (Thread thread : threads) {
      thread.join();
    }

    for (PowerCalculator powerCalculator : powerCalculators) {
      totalPower += powerCalculator.getTotalPower();
    }

    return totalPower;
  }
}
