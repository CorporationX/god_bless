package school.faang.superheroes_battle_BJS2_38409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public final static int GET_EVEN_NUMBER = 2;
    public final static int GET_ULTIMATE_HERO = 1;
    public final static int DELETE_ODD_HERO = 1;
    public final static int GET_HEROES_PAIR = 2;
    public final static int GET_SECOND_WINNER = 1;
    public final static int WINNER = 0;

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero blackWidow = new Superhero("Black Widow", 7, 8);
        Superhero doctorStrange = new Superhero("Doctor Strange", 9, 8);

        List<Pair> superheroPairs = new ArrayList<>(Arrays.asList(
                new Pair(ironMan, captainAmerica),
                new Pair(blackWidow, doctorStrange),
                new Pair(thor, hulk)
        ));

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        while (winnersFutures.size() != GET_ULTIMATE_HERO) {
            superheroPairs.clear();

            if (winnersFutures.size() % GET_EVEN_NUMBER == 0) {
                repeatBattle(superheroPairs, winnersFutures, winnersFutures.size());
            } else {
                repeatBattle(superheroPairs, winnersFutures, winnersFutures.size() - DELETE_ODD_HERO);
            }
            winnersFutures = superheroBattle.runCompetitions(superheroPairs);
        }

        superheroBattle.getExecutor().shutdown();
        try {
            System.out.println("Ultimate winner: " + winnersFutures.get(WINNER).get().getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void repeatBattle(List<Pair> superheroPairs,
                                     List<Future<Superhero>> winnersFutures, int listSize) {
        for (int i = 0; i < listSize; i += GET_HEROES_PAIR) {
            try {
                superheroPairs.add(new Pair(winnersFutures.get(i).get(),
                        winnersFutures.get(i + GET_SECOND_WINNER).get()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        winnersFutures.clear();
    }
}