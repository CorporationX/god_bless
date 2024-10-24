package school.faang.task4110;


import school.faang.task4110.marvel.MyPair;
import school.faang.task4110.marvel.Superhero;
import school.faang.task4110.marvel.SuperheroBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero spiderMan = new Superhero("SpiderMan", 6, 9);
        Superhero wanda = new Superhero("Wanda", 10, 6);

        SuperheroBattle battle = new SuperheroBattle();

        List<Future<Superhero>> superHeroes = battle.runCompetitions(List.of(
                new MyPair(ironMan, captainAmerica),
                new MyPair(thor, hulk),
                new MyPair(spiderMan, wanda)
        ));
        printFightWinner(superHeroes);

        Future<Superhero> excessHero = null;
        while (superHeroes.size() != 1) {
            if (superHeroes.size() % 2 != 0) {
                excessHero = superHeroes.get(0);
                superHeroes.remove(0);
            }

            List<MyPair<Superhero>> sups = new ArrayList<>();

            for (int i = 0; i < superHeroes.size() - 1; i++) {
                try {
                    sups.add(new MyPair<Superhero>(superHeroes.get(i).get(), superHeroes.get(i + 1).get()));
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

            superHeroes = battle.runCompetitions(sups);
            printFightWinner(superHeroes);

            if (excessHero != null) {
                superHeroes.add(excessHero);
            }
            excessHero = null;
        }

        battle.shutdown();
    }

    public static void printFightWinner(List<Future<Superhero>> superHeroes) {
        for (int i = 0; i < superHeroes.size(); i++) {
            try {
                Superhero winner = superHeroes.get(i).get();
                System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}

