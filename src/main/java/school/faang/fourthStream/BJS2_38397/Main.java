package school.faang.fourthStream.BJS2_38397;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        List<Superhero> superheroes = new ArrayList<>();

        superheroes.add(new Superhero("Iron Man", 9, 6));
        superheroes.add(new Superhero("Captain America", 8, 8));
        superheroes.add(new Superhero("Thor", 10, 7));
        superheroes.add(new Superhero("Hulk", 10, 4));
        superheroes.add(new Superhero("SpiderMan", 5, 12));

        superheroBattle.startTournament(superheroes);
    }
}
