package faang.school.godbless.marvel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
  public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> heroes) {
    List<Future<Superhero>> result = new ArrayList<>();
    ExecutorService executor = Executors.newFixedThreadPool(5);

    for (var pair : heroes) {
      Future<Superhero> winner = executor.submit(() -> fight(pair.getFirst(), pair.getSecond()));
      result.add(winner);
    }

    executor.shutdown();

    return result;
  }

  private Superhero fight(Superhero first, Superhero second) {
    first.setHealth(second.getAgility() + second.getStrength());
    second.setHealth(first.getAgility() + first.getStrength());
    return first.getHealth() > second.getHealth() ? first : second;
  }
}
