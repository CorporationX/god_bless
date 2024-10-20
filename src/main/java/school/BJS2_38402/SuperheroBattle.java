package school.BJS2_38402;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroes) {
        ExecutorService service = Executors.newFixedThreadPool(superheroes.size());
        List<Future<Superhero>> futures = new ArrayList<>();
        for (Pair<Superhero, Superhero> superhero : superheroes) {
            futures.add(service.submit(() -> {
                TreeSet<Superhero> superheroSet = new TreeSet<>();
                superheroSet.add(superhero.getFirst());
                superheroSet.add(superhero.getSecond());
                return superheroSet.last();
            }));
        }
        service.shutdown();
        return futures;
    }


}
