package faang.school.godbless.bjs2_18959;

import faang.school.godbless.bjs2_18959.creatures.Angel;
import faang.school.godbless.bjs2_18959.creatures.Creature;
import faang.school.godbless.bjs2_18959.creatures.Griffin;
import faang.school.godbless.bjs2_18959.creatures.Pikeman;
import faang.school.godbless.bjs2_18959.creatures.Swordman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static faang.school.godbless.bjs2_18959.Constants.DEFAULT_AMOUNT;

public class Main {
    public static void main(String[] args) {
        var firstHero = initHero("John");
        var secondHero = initHero("Ivan");

        Battlefield battlefield;
        if (defineFirstMove(firstHero)) {
            battlefield = new Battlefield(firstHero, secondHero);
        } else {
            battlefield = new Battlefield(secondHero, firstHero);
        }

        var winner = battlefield.battle();
    }

    private static Hero initHero(String name) {
        var army = initRandomArmy();
        return new Hero(name, army);
    }

    private static boolean defineFirstMove(Hero hero) {
        return new Random().nextBoolean();
    }

    private static List<Creature> initRandomArmy() {
        var random = new Random();
        int amount = DEFAULT_AMOUNT;
        List<Creature> creatures = new ArrayList<>();
        while (amount > 0) {
            var value = random.nextInt(4);
            Creature creature = switch (value) {
                case 0 -> new Angel("Angel");
                case 1 -> new Griffin("Griffin");
                case 2 -> new Swordman("Swordman");
                case 3 -> new Pikeman("Pikeman");
                default -> throw new IllegalStateException("Unexpected value: " + value);
            };
            creatures.add(creature);
            amount = amount - creature.getPrice();
        }

        return creatures;
    }
}
