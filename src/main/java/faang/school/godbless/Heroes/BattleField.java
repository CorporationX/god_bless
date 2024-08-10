package faang.school.godbless.Heroes;

import lombok.AllArgsConstructor;
import java.util.Random;

@AllArgsConstructor
public class BattleField {
    private Hero hero1;
    private Hero hero2;

    public Hero battle() {
        int damageHero1 = hero1.getTotalArmyDamage();
        int damageHero2 = hero2.getTotalArmyDamage();

        System.out.println(hero1.getName() + " Total Damage: " + damageHero1);
        System.out.println(hero2.getName() + " Total Damage: " + damageHero2);

//        Гейм-дизайнерское решение
        double winPercentage = (hero1.getTotalArmyDamage() + hero2.getTotalArmyDamage()) / 100;
        int hero1Rate = (int) Math.floor((double) hero1.getTotalArmyDamage()/winPercentage);
        int hero2Rate = (int) Math.ceil((double) hero2.getTotalArmyDamage()/winPercentage);
        System.out.println("Win Rate: " + hero1Rate + "% VS " +  + hero2Rate + "%");

        int winRate = new Random().nextInt(0,101);
//        Гейм-дизайнерское решение
        if (winRate == 0) {
            System.out.println("It's a tie");
            return null;
        }else if (winRate <= hero1Rate) {
            System.out.println(hero1.getName() + " wins!");
            return hero1;
        } else if (winRate > hero2Rate) {
            System.out.println(hero2.getName() + " wins!");
            return hero2;
        } else {
            return null;
        }

    }
}
