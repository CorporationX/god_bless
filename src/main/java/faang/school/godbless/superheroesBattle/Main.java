package faang.school.godbless.superheroesBattle;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        List<Map.Entry<Superhero, Superhero>> superheroPairs = new ArrayList<>();
        superheroPairs.add(new AbstractMap.SimpleEntry<>(ironMan, captainAmerica));
        superheroPairs.add(new AbstractMap.SimpleEntry<>(thor, hulk));

        superheroBattle.runTournament(superheroPairs);
    }

}
