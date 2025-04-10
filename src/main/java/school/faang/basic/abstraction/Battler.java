package school.faang.basic.abstraction;

import lombok.extern.slf4j.Slf4j;
import school.faang.basic.abstraction.characters.Character;
import school.faang.basic.abstraction.characters.Randomizer;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Battler {

    private static final int HERO_GET_HIT_ROLL = 4;
    private static final int MIN_ROLL = 1;
    private static final int MAX_ROLL = 21;

    public static List<Character> battle(List<Character> heroArmy, List<Character> villainArmy) {

        List<Character> heroesToFight = new ArrayList<>(heroArmy);
        List<Character> villainsToFight = new ArrayList<>(villainArmy);

        while (!heroesToFight.isEmpty() && !villainsToFight.isEmpty()) {
            Fighter heroFighter = new Fighter(Randomizer.pickRandomMember(heroesToFight), heroesToFight);
            Fighter vilainFighter = new Fighter(Randomizer.pickRandomMember(villainsToFight), villainsToFight);
            Fighter loser = fight(heroFighter, vilainFighter);
            removeBodies(loser);
        }
        return heroesToFight.isEmpty() ? villainsToFight : heroesToFight;
    }

    private static Fighter fight(Fighter hero, Fighter villain) {
        int diceRoll = new SecureRandom().nextInt(MIN_ROLL, MAX_ROLL);
        if (diceRoll < HERO_GET_HIT_ROLL) {
            villain.character().hitOpponent(hero.character());
            return hero;
        } else {
            hero.character().hitOpponent(villain.character());
            return villain;
        }
    }

    private static void removeBodies(Fighter loser) {
        if (loser.character().isDead()) {
            loser.army().remove(loser.character());
        }
    }
}
