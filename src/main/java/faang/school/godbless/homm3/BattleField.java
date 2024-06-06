package faang.school.godbless.homm3;

import java.util.Map;

public class BattleField {

    public String battle(Hero hero1, Hero hero2) {
        int hero1ArmyPoints = calculateArmyPoints(hero1);
        int hero2ArmyPoints = calculateArmyPoints(hero2);

        Hero winner = hero1ArmyPoints > hero2ArmyPoints ? hero1 : hero2;
        return "Победу одержал - " + winner;
    }

    public int calculateArmyPoints(Hero hero) {
        int armyPoints = 0;
        for (Map.Entry<String, Creature> creatureValue : hero.getArmy().entrySet()) {
            armyPoints += (creatureValue.getValue().getQuantity() + creatureValue.getValue().getDefense() + creatureValue.getValue().getDamage()) * hero.getLevel();
        }
        return armyPoints;
    }
}
