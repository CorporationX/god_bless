package school.faang.sprint_4.task_43578;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 10, 9);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        List<Pair<Superhero, Superhero>> superheroPairs = new ArrayList<>(
                List.of(new Pair<>(ironMan, captainAmerica),
                        new Pair<>(thor, hulk))
        );

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetition(superheroPairs);

        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                System.out.println("Победитель битвы " + (i + 1) + " " + winnersFutures.get(i).get().name());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Произошла ошибка!");
            }
        }

        superheroBattle.shutdown();
    }
}
