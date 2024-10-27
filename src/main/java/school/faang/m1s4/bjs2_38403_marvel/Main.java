package school.faang.m1s4.bjs2_38403_marvel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Superhero> participants = new ArrayList<>(List.of(
                new Superhero("Spider-Man", 6, 10),
                new Superhero("Iron Man", 8, 6),
                new Superhero("Thor", 10, 6),
                new Superhero("Captain America", 7, 8),
                new Superhero("Hulk", 10, 4),
                new Superhero("Black Widow", 4, 9),
                new Superhero("Doctor Strange", 5, 5),
                new Superhero("Black Panther", 7, 9),
                new Superhero("Loki", 6, 8),
                new Superhero("Thanos", 10, 5),
                new Superhero("Green Goblin", 7, 7),
                new Superhero("Ultron", 8, 6),
                new Superhero("Venom", 9, 7),
                new Superhero("Deadpool", 6, 6),
                new Superhero("Magneto", 8, 7),
                new Superhero("Galactus", 10, 4)
        ));

        new SuperheroBattle().runTournament(participants);
    }
}
