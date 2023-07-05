package faang.school.godbless.superheroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairList) {
        ExecutorService executorService = Executors.newFixedThreadPool(pairList.size());
        Future<Superhero> superheroFuture = null;
        List<Future<Superhero>> future = new ArrayList<>();
        for (Pair<Superhero, Superhero> superhero : pairList) {
            Superhero superhero1 = superhero.getSuperhero1();
            Superhero superhero2 = superhero.getSuperhero2();

            superheroFuture = executorService.submit(() -> {
                int super1 = superhero1.getStrength() + superhero1.getAgility();
                int super2 = superhero2.getStrength() + superhero2.getAgility();
                if (super1 >= super2) {
                    return superhero1;
                } else {
                    return superhero2;
                }
            });
            future.add(superheroFuture);
        }
        executorService.shutdown();
        return future;
    }
}
