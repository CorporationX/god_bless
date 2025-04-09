package school.faang.basic.abstraction;

import lombok.extern.slf4j.Slf4j;
import school.faang.basic.abstraction.characters.Archer;
import school.faang.basic.abstraction.characters.Character;
import school.faang.basic.abstraction.characters.Mage;
import school.faang.basic.abstraction.characters.Trainee;
import school.faang.basic.abstraction.characters.Warrior;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {

    private static final int HERO_GET_HIT_ROLL = 4;
    private static final int MIN_ROLL = 1;
    private static final int MAX_ROLL = 21;

    public static void main(String[] args) {
        Warrior hero = new Warrior("Aragorn");
        List<Character> enemies = List.of(
                new Warrior("Ugly ork"),
                new Warrior("Mighty ork"),
                new Archer("Grumpy ork"),
                new Archer("Filthy ork-archer"),
                new Mage("Snicky ork-shaman"),
                new Trainee("Ork-intern")
        );

        List<Character> enemiesLeft = fight(hero, enemies);

        if (enemiesLeft.isEmpty()) {
            hero.praise();
        } else {
            enemiesLeft.forEach(Character::praise);
            log.info("Hero could not handle it :(((");
        }

    }

    private static List<Character> fight(Character hero, List<Character> enemies) {
        SecureRandom secureRandom = new SecureRandom();
        List<Character> enemiesToFight = new ArrayList<>(enemies);

        while (!hero.isDead() && !enemiesToFight.isEmpty()) {
            int diceRoll = secureRandom.nextInt(MIN_ROLL, MAX_ROLL);
            if (diceRoll < HERO_GET_HIT_ROLL) {
                Character turnAttacker = enemiesToFight.get(secureRandom.nextInt(0, enemiesToFight.size()));
                turnAttacker.hitOpponent(hero);
            } else {
                Character turnOpponent = enemiesToFight.get(secureRandom.nextInt(0, enemiesToFight.size()));
                hero.hitOpponent(turnOpponent);
                if (turnOpponent.isDead()) {
                    enemiesToFight.remove(turnOpponent);
                }
            }
        }
        return enemiesToFight;
    }
}