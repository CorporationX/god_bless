package faang.school.godbless.heroes_of_might_and_magic_iii;

import java.util.Map;

//I have no idea whats happening here and why its so complicated, task is too ambiguous
public class Battlefield {
    Hero hero1 = new Hero("Hero1", "faction1", 11, 1);
    Hero hero2 = new Hero("Hero2", "faction2", 11, 1);

    public Battlefield() {
        hero1.addCreature(new Pikeman("pik"), 10);
        hero1.addCreature(new Pikeman("pik"), 30);
        hero1.addCreature(new Angel("ang"), 10);

        hero2.addCreature(new Griffin("griff"), 1);
        hero2.addCreature(new Swordman("sword"), 1);
        hero2.addCreature(new Angel("ang"), 50);
    }

//    calculates delta hp of every army, one with larger wins
    public Hero battle() {
        Map<Creature, Integer> army1 = hero1.getArmy();
        Map<Creature, Integer> army2 = hero2.getArmy();

        int army1Damage = 0, army2Damage = 0, army1Hp = 0, army2Hp = 0;
        for (Map.Entry<Creature, Integer> entry : army1.entrySet()) {
            army1Damage += entry.getValue() * entry.getKey().getDamage();
//            defence like hp idk
            army1Hp += entry.getValue() * entry.getKey().getDefence();
        }
        for (Map.Entry<Creature, Integer> entry : army2.entrySet()) {
            army2Damage += entry.getValue() * entry.getKey().getDamage();
            army2Hp += entry.getValue() * entry.getKey().getDefence();
        }
        if ((army1Hp - army2Damage) > (army2Hp - army1Damage)) {
            return hero1;
        }
        return hero2;
    }

}
