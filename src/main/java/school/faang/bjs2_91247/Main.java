package school.faang.bjs2_91247;

import school.faang.bjs2_91247.character.Archer;
import school.faang.bjs2_91247.character.Magician;
import school.faang.bjs2_91247.character.Swordsman;
import school.faang.bjs2_91247.character_groups.Army;
import school.faang.bjs2_91247.character_groups.Squad;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad<Magician> magicians =
                new Squad<>(List.of(new Magician(), new Magician(), new Magician(), new Magician()));
        Squad<Archer> archers =
                new Squad<>(List.of(new Archer(), new Archer(), new Archer(), new Archer(), new Archer()));
        Squad<Swordsman> swordsmen =
                new Squad<>(List.of(new Swordsman(), new Swordsman(), new Swordsman(), new Swordsman()));

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