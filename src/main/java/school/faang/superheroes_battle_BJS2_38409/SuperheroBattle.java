package school.faang.superheroes_battle_BJS2_38409;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
public class SuperheroBattle {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public List<Future<Superhero>> runCompetitions(List<Pair> competitions) {
        List<Future<Superhero>> futures = new ArrayList<>();

        competitions.forEach(pair -> futures.add(executor.submit(() -> {
            int totalPower1 = (pair.getFistSuperhero().getAgility() + pair.getFistSuperhero().getStrength());
            int totalPower2 = (pair.getSecondSuperhero().getAgility() + pair.getSecondSuperhero().getStrength());
            return totalPower1 >= totalPower2 ? pair.getFistSuperhero() : pair.getSecondSuperhero();
        })));
        return futures;
    }
}