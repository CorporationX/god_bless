package school.faang.sprint_4.task_43578;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class SuperheroBattle {
    private static final int POOL_SIZE = 3;

    ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public List<Future<Superhero>> runCompetition(List<Pair<Superhero, Superhero>> pairs) {
        return pairs
                .stream()
                .map(pair -> executor.submit(
                        () -> {
                            System.out.println("Идет битва между " + pair.first().name()
                                    + " и " + pair.second().name());
                            int firstPower = pair.first().strength() + pair.first().agility();
                            int secondPower = pair.second().strength() + pair.second().agility();
                            return firstPower > secondPower ? pair.first() : pair.second();
                        }
                ))
                .toList();
    }

    public void shutdown() {
        executor.shutdown();
    }

    /*public Superhero findTheStrongestHero(List<Pair<Superhero, Superhero>> pairs) {

    }*/
}
