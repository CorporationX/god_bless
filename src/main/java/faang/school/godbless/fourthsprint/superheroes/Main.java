package faang.school.godbless.fourthsprint.superheroes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SuperheroBattle superheroBattle = new SuperheroBattle();
        List<Superhero> superheroes = getSuperheroes();

        superheroBattle.findStrongestSuperhero(superheroes);
    }

    public static List<Superhero> getSuperheroes() {

        return Arrays.asList(
                new Superhero("Iron Man", 9, 6),
                new Superhero("Captain America", 8, 8),
                new Superhero("Thor", 10, 6),
                new Superhero("Hulk", 10, 4),
                new Superhero("Black Widow", 7, 8),
                new Superhero("Hawkeye", 6, 9),
                new Superhero("Spiderman", 8, 7),
                new Superhero("Doctor Strange", 9, 5),
                new Superhero("Black Panther", 8, 6),
                new Superhero("Scarlet Witch", 9, 6),
                new Superhero("Vision", 8, 6),
                new Superhero("Antman", 7, 8),
                new Superhero("Wolverine", 9, 5),
                new Superhero("Deadpool", 8, 6),
                new Superhero("Quicksilver", 7, 9)
        );
    }
}
