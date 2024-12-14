package school.faang.HeroesOfMightandMagic;

import school.faang.HeroesOfMightandMagic.Creature.Angel;
import school.faang.HeroesOfMightandMagic.Creature.Creature;
import school.faang.HeroesOfMightandMagic.Creature.Griffin;
import school.faang.HeroesOfMightandMagic.Creature.Pikeman;
import school.faang.HeroesOfMightandMagic.Creature.Swordman;

public class Main {
    public static void main(String[] args) {
        Hero arthur = new Hero("Arthur", "Fraction", 88, 7);
        Hero morgan = new Hero("Morgan", "Fraction", 76, 8);

        Creature angel = new Angel("Angel");
        Creature griffin = new Griffin("Dragon");
        Creature pikeman = new Pikeman("Pikeman");
        Creature swordsman = new Swordman("Swordman");

        arthur.addCreature(angel, 3);
        arthur.addCreature(griffin, 2);

        morgan.addCreature(pikeman, 4);
        morgan.addCreature(swordsman, 2);

        Battlefield battlefield = new Battlefield(arthur, morgan);

        battlefield.printResult();
    }
}
