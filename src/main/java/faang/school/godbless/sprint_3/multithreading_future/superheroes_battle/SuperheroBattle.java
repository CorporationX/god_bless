package faang.school.godbless.sprint_3.multithreading_future.superheroes_battle;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class SuperheroBattle {

    public List<Pair<Superhero, Superhero>> makeNewPairs(List<Superhero> winners) {
        List<Pair<Superhero, Superhero>> newPairs = new ArrayList<>();
        int batch = 2;
        for (int i = 0; i < winners.size(); i += batch) {//6
            int secondHero = Math.min(i + 1, winners.size() - 1);
            Pair<Superhero, Superhero> pair = new Pair<>(winners.get(i), winners.get(secondHero));
            newPairs.add(pair);
        }
        if (winners.size() % 2 == 1) {
            Superhero lastHero = winners.get(winners.size() - 1);
            Pair<Superhero, Superhero> lastPair = new Pair<>(lastHero, lastHero);
            newPairs.add(lastPair);
        }
        return newPairs;
    }

    @SneakyThrows
    public static void runTournament(List<Pair<Superhero, Superhero>> pairs) {
        SuperheroBattle battle = new SuperheroBattle();
        List<Future<Superhero>> list = battle.runCompetitions(pairs);
        while (list.size() > 1) {
            List<Superhero> superheroes = new ArrayList<>();
            for (Future<Superhero> future : list) {
                try {
                    Superhero hero = future.get();
                    superheroes.add(hero);
                } catch (InterruptedException | ExecutionException exception) {
                    exception.printStackTrace();
                }
            }
            List<Pair<Superhero, Superhero>> secondList = battle.makeNewPairs(superheroes);
            list = battle.runCompetitions(secondList);
        }
        System.out.printf("Окончательным победителем у нас является %s%n", list.get(0).get().getName());
    }

    private Superhero battle(Superhero firstHero, Superhero secondHero) {
        System.out.printf("Начинаем бой между %s и %s%n", firstHero.getName(), secondHero.getName());
        int firstHeroTotalPower = firstHero.getStrength() + firstHero.getAgility();
        int secondHeroTotalPower = secondHero.getStrength() + secondHero.getAgility();
        if (firstHeroTotalPower == secondHeroTotalPower) {
            System.out.printf("У нас ничья между %s и %s%n", firstHero.getName(), secondHero.getName());
            int random = ThreadLocalRandom.current().nextInt(2);
            if (random == 0) {
                return firstHero;
            }
            return secondHero;
        }
        return firstHeroTotalPower > secondHeroTotalPower ? firstHero : secondHero;
    }

    private List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        List<Future<Superhero>> winners = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (Pair<Superhero, Superhero> pair : pairs) {
            Future<Superhero> winner = service.submit(() -> battle(pair.getFirst(), pair.getSecond()));
            winners.add(winner);
        }
        service.shutdown();
        return winners;
    }
}