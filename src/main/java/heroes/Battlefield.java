package heroes;

import heroes.item.Creature;

import java.util.Map;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int power1 = calcPower(hero1);
        int power2 = calcPower(hero2);

        if (power1 > power2) {
            return hero1;
        } else if (power1 < power2) {
            return hero2;
        } else throw new IllegalArgumentException("The heroes' powers are equal, try again later");
    }

    public static int calcPower(Hero hero) {
        // power = "Attack * Quantity"
        Map<String, Creature> army = hero.getArmy();
        int power = 0;
        for (Map.Entry<String, Creature> entry : army.entrySet()) {
            power += (entry.getValue().getAttack() * entry.getValue().getQuantity());
        }
        return power;
    }
}