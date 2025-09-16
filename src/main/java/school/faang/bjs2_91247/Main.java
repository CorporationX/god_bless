package school.faang.bjs2_91247;

import school.faang.bjs2_91247.character.Archer;
import school.faang.bjs2_91247.character.Magician;
import school.faang.bjs2_91247.character.Swordsman;
import school.faang.bjs2_91247.character_groups.Army;
import school.faang.bjs2_91247.character_groups.Squad;

import static school.faang.bjs2_91247.character_groups.Squad.CharacterClass.*;

public class Main {
    public static void main(String[] args) {
        Squad magicians = new Squad(MAGICIANS, new Magician(), new Magician(), new Magician(), new Magician());
        Squad archers = new Squad(ARCHERS, new Archer(), new Archer(), new Archer(), new Archer(), new Archer());
        Squad swordsmen = new Squad(SWORDSMEN, new Swordsman(), new Swordsman(), new Swordsman(), new Swordsman());

        Army army = new Army();
        army.addSquad(magicians);
        army.addSquad(archers);
        army.addSquad(swordsmen);

        try {
            System.out.println(army.calculateTotalPower());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Поток %s: Меня прервали", Thread.currentThread().getName());
        }
    }
}