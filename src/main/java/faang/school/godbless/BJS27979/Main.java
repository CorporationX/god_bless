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

        arthur.addCreature(new Dwarf(400));
        arthur.addCreature(new GoldGolem(50));
        arthur.addCreature(new Naga(16));
        arthur.removeCreature("Naga", 1);
        arthur.addCreature(new Titan(4));
        arthur.printArmy();

        merlin.addCreature(new Bandit(400));
        merlin.addCreature(new Minotaur(50));
        merlin.addCreature(new Efreet(15));
        merlin.addCreature(new BlackDragon(2));
        merlin.printArmy();

        Battlefield fight = new Battlefield(arthur, merlin);
        fight.getBattle();
        arthur.printArmy();
        merlin.removeCreature("Naga", 1);
        merlin.printArmy();

    }
}