package school.faang.task50582;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        List<Pair<Superhero>> superheroPairs = List.of(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk)
        );

        SuperheroBattle battle = new SuperheroBattle();
        battle.runCompetitions(superheroPairs);
    }
}
