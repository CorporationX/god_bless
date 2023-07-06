package faang.school.godbless.sprint_3.multithreading_future.superheroes_battle;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        List<Pair<Superhero, Superhero>> superheroPairs = Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk)
        );
        SuperheroBattle.runTournament(superheroPairs);
    }
}