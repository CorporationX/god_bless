package faang.school.godbless.Heroes;

import lombok.AllArgsConstructor;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Random;

@AllArgsConstructor
public class BattleField {
    private Hero hero1;
    private Hero hero2;


    public Hero battle(){
        int damageHero1 = hero1.getTotalArmyDamage();
        int damageHero2 = hero2.getTotalArmyDamage();

        System.out.println(hero1.getName() + " Total Damage: " + damageHero1);
        System.out.println(hero2.getName() + " Total Damage: " + damageHero2);

        int winRate = new Random().nextInt(damageHero1 + damageHero2 + 1);

        if (winRate == 0){
            System.out.println("It's a tie");
            return null;
        }else if (winRate <= damageHero1){
            System.out.println(hero1.getName() + " wins!");
            return hero1;
        } else if (winRate > damageHero1) {
            System.out.println(hero2.getName() + " wins!");
            return hero2;
        } else {
            return null;
        }

    }
}
