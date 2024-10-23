package school.BJS2_38402;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        List<Superhero> superheroes = new ArrayList<>();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 15, 4);
        Superhero spiderMan = new Superhero("Spider Man", 6, 9);
        superheroes.add(ironMan);
        superheroes.add(captainAmerica);
        superheroes.add(thor);
        superheroes.add(hulk);
        superheroes.add(spiderMan);

        ExecutorService service = Executors.newFixedThreadPool(superheroes.size() / 2 + 1);
        SuperheroBattle superheroBattle = new SuperheroBattle(superheroes, service);
        superheroBattle.battle();

    }
}
