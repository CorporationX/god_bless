package Sprint_4.BJS2_38502;

import java.util.List;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        Superhero hero1 = new Superhero("Hero1", 80, 70);
        Superhero hero2 = new Superhero("Hero2", 90, 60);
        Superhero hero3 = new Superhero("Hero3", 70, 80);
        Superhero hero4 = new Superhero("Hero4", 60, 90);

        List<Pair<Superhero, Superhero>> pairs = List.of(
                new Pair<>(hero1, hero2),
                new Pair<>(hero3, hero4)
        );

        SuperheroBattle battle = new SuperheroBattle();
        List<Future<Superhero>> results = battle.runCompetitions(pairs);

        System.out.println("Победители соревнований:");
        for (Future<Superhero> result : results) {
            System.out.println(result.get());
        }
    }
}

