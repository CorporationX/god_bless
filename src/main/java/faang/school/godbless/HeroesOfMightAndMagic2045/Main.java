package faang.school.godbless.HeroesOfMightAndMagic2045;

import faang.school.godbless.HeroesOfMightAndMagic2045.Troops.Angel;
import faang.school.godbless.HeroesOfMightAndMagic2045.Troops.Griffin;
import faang.school.godbless.HeroesOfMightAndMagic2045.Troops.Pikeman;
import faang.school.godbless.HeroesOfMightAndMagic2045.Troops.Swordman;

public class Main {

    public static void main(String[] args) {
        System.out.println("TEST 1: Creating first hero (James) with army");
        Hero james = new Hero("James", "North", 85169.51, 29);
        james.addCreature(new Pikeman(16), 37);
        james.addCreature(new Swordman(14), 46);
        james.addCreature(new Griffin(25), 4);
        james.addCreature(new Angel(21), 1);
        System.out.println(james.getArmy().toString());

        System.out.println("TEST 2: Creating second hero (Hugo) with army");
        Hero hugo = new Hero("Hugo", "South", 85132.11, 28);
        hugo.addCreature(new Pikeman(16), 37);
        hugo.addCreature(new Swordman(14), 46);
        hugo.addCreature(new Griffin(20), 4);
        hugo.addCreature(new Angel(33), 1);
        System.out.println(hugo.getArmy().toString());

        System.out.println("TEST 3: FIGHT!");
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
        Battlefield.battle(james, hugo);
    }
}
