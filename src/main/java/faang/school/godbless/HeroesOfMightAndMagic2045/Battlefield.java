package faang.school.godbless.HeroesOfMightAndMagic2045;

import faang.school.godbless.HeroesOfMightAndMagic2045.Troops.Creature;

import java.util.List;

public class Battlefield {

    public static void battle(Hero hero1, Hero hero2) {
        List<Creature> hero1Army = hero1.getArmy();
        List<Creature> hero2Army = hero2.getArmy();
        while (true) {
            fight(hero1, hero2);
            fight(hero2, hero1);
            removeIfAllDead(hero1Army);
            removeIfAllDead(hero2Army);
            if (hero1Army.isEmpty()) {
                System.out.println(hero2.getName() + " WINS! ");
                break;
            } else if (hero2Army.isEmpty()) {
                System.out.println(hero1.getName() + " WINS!");
                break;
            }
        }
    }

    private static void fight(Hero attacker, Hero defender) {
        int i = (int) (Math.random() * attacker.getArmy().size());
        int j = (int) (Math.random() * defender.getArmy().size());
        int damage = attacker.getArmy().get(i).getDamage(defender.getArmy().get(j));
        defender.removeCreature(defender.getArmy().get(j), damage);
    }

    private static void removeIfAllDead(List<Creature> army) {
        for (int i = 0; i < army.size(); i++) {
            if (army.get(i).getQuantity() == 0) {
                army.remove(i);
            }
        }
    }
}
