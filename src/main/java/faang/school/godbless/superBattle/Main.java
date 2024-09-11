package faang.school.godbless.superBattle;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captain = new Superhero("Captain", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero test = new Superhero("Test", 12, 3);
        Superhero biba = new Superhero("Biba", 9, 3);
        Superhero boba = new Superhero("Boba", 7, 3);
        Superhero lupa = new Superhero("Lupa", 8, 3);
        Superhero pupa = new Superhero("Pupa", 1, 3);

        List<MyPair<Superhero, Superhero>> superheroPairs = Arrays.asList(
                new MyPair<>(ironMan, captain),
                new MyPair<>(thor, hulk),
                new MyPair<>(test, null),
                new MyPair<>(biba, boba),
                new MyPair<>(lupa, pupa)
        );

        try {
            Superhero winner = superheroBattle.runCompetitions(superheroPairs).get();
            System.out.println("And the winner is: " + winner.name());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
