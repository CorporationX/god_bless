package faang.school.godbless.BJS27979;

import faang.school.godbless.BJS27979.Creatures.Bandit;
import faang.school.godbless.BJS27979.Creatures.BlackDragon;
import faang.school.godbless.BJS27979.Creatures.Dwarf;
import faang.school.godbless.BJS27979.Creatures.Efreet;
import faang.school.godbless.BJS27979.Creatures.GoldGolem;
import faang.school.godbless.BJS27979.Creatures.Minotaur;
import faang.school.godbless.BJS27979.Creatures.Naga;
import faang.school.godbless.BJS27979.Creatures.Titan;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Hero arthur = new Hero("Arthur", "Academy", 15, new ArrayList<>());
        arthur.printArmy();
        Hero merlin = new Hero("Merlin", "Asylum", 10, new ArrayList<>());
        merlin.printArmy();

        arthur.addCreature(new Dwarf(600));
        arthur.addCreature(new GoldGolem(60));
        arthur.addCreature(new Naga(20));
        arthur.addCreature(new Titan(4));
        arthur.printArmy();

        merlin.addCreature(new Bandit(600));
        merlin.addCreature(new Minotaur(60));
        merlin.addCreature(new Efreet(20));
        merlin.addCreature(new BlackDragon(2));
        merlin.printArmy();

        Battlefield fight = new Battlefield(arthur, merlin);
        fight.getBattle();
        arthur.printArmy();
        merlin.printArmy();

    }
}
