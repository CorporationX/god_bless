package heroOfSwordAndMagic;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class BattleField {
    public static void main(String[] args) {
        Map<Creature, Integer> heroArmy1 = new HashMap<>();
        Map<Creature, Integer> heroArmy2 = new HashMap<>();

        Hero superman = new Hero("Superman", "X", 2000, 500);
        Hero batman = new Hero("Batman", "X", 1500, 300);

        superman.addCreature(new Angel("Mickael"), 1 , heroArmy1);
        superman.addCreature(new Griffin("WhiteHead"), 100, heroArmy1);
        superman.addCreature(new Swordman("King Guardian"), 1000, heroArmy1);
        superman.addCreature(new Pikeman("Pikeman"), 500, heroArmy1);

        batman.addCreature(new Angel("Mickael"), 1, heroArmy2);
        batman.addCreature(new Griffin("WhiteHead"), 70, heroArmy2);
        batman.addCreature(new Swordman("King Guardian"), 500, heroArmy2);
        batman.addCreature(new Pikeman("Pikeman"), 300, heroArmy2);


        BattleField.battle(superman,batman, heroArmy1, heroArmy2);
    }

    public static void battle(Hero hero1,Hero hero2, Map<Creature, Integer> heroArmy1, Map<Creature, Integer> heroArmy2) {
        System.out.println(hero1.getName() + " vs " + hero2.getName());
        System.out.println("Round 1");
        int win1 = 0;
        int win2 = 0;
        if (hero1.getLvl() > hero2.getLvl()) {
            win1++;
            System.out.println("Win: " + hero1.getName());
        }
        else {
            win2++;
            System.out.println("Win: " + hero2.getName());
        }

        for (Map.Entry<Creature, Integer> pair : heroArmy1.entrySet()) {
            System.out.println("Battle " + pair.getKey().name);
            int countCreature = pair.getValue();
            for (Map.Entry<Creature, Integer> entry : heroArmy2.entrySet()) {
                int countCreature2 = entry.getValue();

                if (countCreature > countCreature2) {
                    win1++;
                    System.out.println("Win: " + pair.getKey().name + " of first Hero!");
                    break;
                }
                else if (countCreature == countCreature2) {
                    System.out.println("Draw");
                   break;
                }
                else {
                    win2++;
                    System.out.println("Win: " + entry.getKey().name + " of second Hero!");
                    break;
                }
            }

        }

        if (win1 > win2) {
            System.out.println("In this battle win - " + hero1.getName());
        }
        else {
            System.out.println("In this battle win - " + hero2.getName());
        }


    }
}
