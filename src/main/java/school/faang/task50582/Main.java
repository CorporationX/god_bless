package school.faang.task50582;

import java.util.List;

public class Main {
    private static Pair<Superhero> createPair(Superhero hero1,
                                              Superhero hero2) {
        return new Pair<>(hero1, hero2);
    }

    public static void main(String[] args) {
        SuperheroBattle battle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        battle.runCompetitions(List.of(
                createPair(ironMan, captainAmerica),
                createPair(thor, hulk)));
    }
}
