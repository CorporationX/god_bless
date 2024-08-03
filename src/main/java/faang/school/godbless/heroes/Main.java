package faang.school.godbless.heroes;

import faang.school.godbless.heroes.entity.creatures.*;
import faang.school.godbless.heroes.entity.heroes.Hero;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.heroes.Battlefield.battle;

public class Main {
    public static void main(String[] args) {
        Creature redAngel = new Angel("Red-Angel");
        Creature redGriffin = new Griffin("Red-Griffin");
        Creature redPikeman = new Pikeman("Red-Pikeman");
        Creature redSwordman = new Swordman("Red-Swordman");

        Creature blueAngel = new Angel("Blue-Angel");
        Creature blueGriffin = new Griffin("Blue-Griffin");
        Creature bluePikeman = new Pikeman("Blue-Pikeman");
        Creature blueSwordman = new Swordman("Blue-Swordman");

        Hero redHero = new Hero("Red Hero", "Red", 100, 12,
                new ArrayList<>(List.of(redAngel, redGriffin, redPikeman, redSwordman)));
        Hero blueHero = new Hero("Blue Hero", "Blue", 100, 12,
                new ArrayList<>(List.of(blueAngel, blueGriffin, bluePikeman, blueSwordman)));

        redHero.showArmy();
        blueHero.showArmy();

        battle(redHero, blueHero);

        redHero.addCreature(redAngel,20);
        redHero.addCreature(redGriffin,20);
        redHero.addCreature(redPikeman,20);
        redHero.addCreature(redSwordman,20);

        blueHero.addCreature(blueAngel,15);
        blueHero.addCreature(blueGriffin,30);
        blueHero.addCreature(bluePikeman,10);
        blueHero.addCreature(blueSwordman,10);

        redHero.showArmy();
        blueHero.showArmy();

        battle(redHero, blueHero);

        redHero.removeCreature(redAngel,1);
        redHero.removeCreature(redGriffin,1);
        redHero.removeCreature(redPikeman,1);
        redHero.removeCreature(redSwordman,1);

        redHero.showArmy();
        blueHero.showArmy();

        battle(redHero, blueHero);
    }
}
