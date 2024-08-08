package faang.school.godbless.BJS218880;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Battlefield {
    final Hero protagonist;
    final Hero antagonist;
    final Map<String, Creature> goodArmy;
    final Map<String, Creature> badArmy;

    public Battlefield(Hero protagonist, Hero antagonist) {
        this.protagonist = protagonist;
        this.antagonist = antagonist;
        this.goodArmy = protagonist.getArmy();
        this.badArmy = antagonist.getArmy();
    }

    public Hero battle() {
        if (allArmyDamage(goodArmy) > allArmyDamage(badArmy)){
            return protagonist;
        } else if (allArmyDamage(goodArmy) < allArmyDamage(badArmy)) {
            return antagonist;
        }else {
            System.out.println("Ничья");
            return null;
        }
    }

    int allArmyDamage(Map<String, Creature> creatures) {
        int totalDamage = 0;
        for (Creature creature : creatures.values()) {
            totalDamage += creature.getDamage();
        }
        return totalDamage;
    }
}
