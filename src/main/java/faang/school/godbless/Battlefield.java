package faang.school.godbless;

import lombok.Getter;

import java.util.Random;

import static faang.school.godbless.Event.*;

public class Battlefield {


    public static void round(Hero hero, int digitalRandom) {
        switch (digitalRandom)
        {
            case 0:
                raiseTheTroops(hero);
                break;
            case 1:
                attackOfTheNatives(hero);
                break;
            case 2:
                goodSupply(hero);
                break;
            case 3:
                poorSupply(hero);
                break;
            case 4:
                visitTheForge(hero);
                break;
            case 5:
                inspiration(hero);
                break;
            case 6:
                lossOfMorale(hero);
                break;
        }
    }

    public static void battle() {
        int damageFirstArmy = getFirstHero().totalDamageArmy(getFirstHero().getArmy());
        int damageSecondArmy = getSecondHero().totalDamageArmy(getSecondHero().getArmy());

        System.out.println("Сражение началось!");
        System.out.println("Сила армии " + getFirstHero().getName() + " = " + damageFirstArmy);
        System.out.println("Сила армии " + getSecondHero().getName() + " = " + damageSecondArmy);

        if (damageFirstArmy > damageSecondArmy) {
            System.out.println("Победитель: " + getFirstHero().getName());
        } else if (damageFirstArmy < damageSecondArmy){
            System.out.println("Победитель: " + getSecondHero().getName());
        } else {
            System.out.println("Ничья!");
        }
    }
}
