package faang.school.godbless.BJS27979;

import faang.school.godbless.BJS27979.Creatures.Creature;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public void fightRound() {
        Map<Hero, Creature> allCreatures = new HashMap<>();
    }
}
