package faang.school.godbless.super_heroes_battle;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperHeroBattle {
    public List<Future<SuperHero>> runCompetitions(List<Pair> pairs) {
        List<Future<SuperHero>> winHeroes = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(pairs.size());
        for(Pair pair : pairs) {
            Future<SuperHero> winner = executorService.submit(() -> {
                SuperHero superHero1 = pair.getSuperHero1();
                SuperHero superHero2 = pair.getSuperHero2();
                if(superHero1.getPower() > superHero2.getPower()) {
                    System.out.println("The battle between " + superHero1.getName() + " and " + superHero2.getName() + " was won - " + superHero1.getName());

                    return superHero1;
                } else {
                    System.out.println("The battle between " + superHero1.getName() + " and " + superHero2.getName() + " was won - " + superHero2.getName());
                    return superHero2;
                }
            });
            winHeroes.add(winner);
        }
        for(int i = 1; i < winHeroes.size(); i++) {
            try {
                SuperHero superHero1 = winHeroes.get(i-1).get();
                SuperHero superHero2 = winHeroes.get(i).get();
                if(superHero1.getPower() > superHero2.getPower()) {
                    System.out.println("The battle between " + superHero1.getName() + " and " + superHero2.getName() + " was won - " + superHero1.getName());
                } else {
                    System.out.println("The battle between " + superHero1.getName() + " and " + superHero2.getName() + " was won - " + superHero2.getName());
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        return winHeroes;
    }
}
