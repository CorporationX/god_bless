package school.BJS2_38402;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SuperheroBattle {
    List<Superhero> superheroes;
    ExecutorService service;

    public SuperheroBattle(List<Superhero> superheroes, ExecutorService service) {
        this.superheroes = superheroes;
        this.service = service;
    }

    public void battle() {
        List<Superhero> listOfHeroes = superheroes;
        while (listOfHeroes.size() > 1) {
            List<Future<Superhero>> listOfBattleResult = runCompetitions(listOfHeroes);
            listOfHeroes.clear();
            listOfBattleResult.stream().forEach(hero -> {
                try {
                    listOfHeroes.add(hero.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Победитель межгалактической битвы является: " + listOfHeroes.get(0).getName());
        service.shutdown();
    }

    private List<Future<Superhero>> runCompetitions(List<Superhero> superheroes) {
        List<Future<Superhero>> futures = new ArrayList<>();
        Collections.shuffle(superheroes);
        List<Pair<Superhero, Superhero>> pairsOfSuperheroes = getPairsOfSuperheroes(superheroes);
        for (Pair<Superhero, Superhero> superhero : pairsOfSuperheroes) {
            futures.add(service.submit(() -> {
                Superhero superhero1 = superhero.getFirst();
                Superhero superhero2 = superhero.getSecond();
                return getWinner(superhero1, superhero2);
            }));
        }
        return futures;
    }

    private List<Pair<Superhero, Superhero>> getPairsOfSuperheroes(List<Superhero> superheroes) {
        List<Pair<Superhero, Superhero>> listOfPair = new ArrayList<>();
        for (int i = 0; i < superheroes.size() - 1; i += 2) {
            Superhero hero1 = superheroes.get(i);
            Superhero hero2 = superheroes.get(i + 1);
            listOfPair.add(new Pair<>(hero1, hero2));
        }
        if (superheroes.size() % 2 != 0) {
            Superhero superhero = superheroes.get(superheroes.size() - 1);
            listOfPair.add(new Pair<>(superhero, superhero));
        }
        return listOfPair;
    }

    private Superhero getWinner(Superhero superhero1, Superhero superhero2) {
        Superhero winner = superhero1.battleSuperheroes(superhero2);
        System.out.printf("Победитель баттла между %s и %s является: %s\n", superhero1.getName(), superhero2.getName(), winner.getName());
        return winner;
    }

}
