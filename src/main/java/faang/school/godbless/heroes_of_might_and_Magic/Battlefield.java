package faang.school.godbless.heroes_of_might_and_Magic;

import faang.school.godbless.heroes_of_might_and_Magic.creatures.Creature;
import lombok.Data;

import java.util.Map;

@Data
public class Battlefield {
    private Hero firstOpponent;
    private Hero secondOpponent;
    private Map<Creature, Integer> firstOpponentArmy;
    private Map<Creature, Integer> secondOpponentArmy;

    public Battlefield(Hero firstOpponent, Hero secondOpponent) {
        this.firstOpponent = firstOpponent;
        this.secondOpponent = secondOpponent;
        this.firstOpponentArmy = firstOpponent.getArmy();
        this.secondOpponentArmy = secondOpponent.getArmy();
    }

    /*
    По сражению ничего лучше не придумал, можно написать алгоритм,
    когда герои атакуют друг друга по очереди рандомными юнитами, но это запарно)
    */
    public Hero battle() {

        int firstOpponentDamage = 0;
        int firstOpponentDefense = 0;
        int secondOpponentDamage = 0;
        int secondOpponentDefense = 0;

        for (Map.Entry<Creature, Integer> entry : firstOpponentArmy.entrySet()) {
            firstOpponentDamage += entry.getKey().getDamage() * entry.getValue();
            firstOpponentDefense += entry.getKey().getDefense() * entry.getValue();
        }

        for (Map.Entry<Creature, Integer> entry : secondOpponentArmy.entrySet()) {
            secondOpponentDamage += entry.getKey().getDamage() * entry.getValue();
            secondOpponentDefense += entry.getKey().getDefense() * entry.getValue();
        }

        if (firstOpponentDefense - secondOpponentDamage > secondOpponentDefense - firstOpponentDamage) {
            return firstOpponent;
        } else {
            return secondOpponent;
        }
    }
}