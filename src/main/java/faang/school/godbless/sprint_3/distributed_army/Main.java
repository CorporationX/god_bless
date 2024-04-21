package faang.school.godbless.sprint_3.distributed_army;

import faang.school.godbless.sprint_3.distributed_army.model.Archer;
import faang.school.godbless.sprint_3.distributed_army.model.Army;
import faang.school.godbless.sprint_3.distributed_army.model.Mage;
import faang.school.godbless.sprint_3.distributed_army.model.Swordsman;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Army army = new Army(
                List.of(
                        new Archer(10),
                        new Archer(12),
                        new Archer(12),
                        new Archer(13),
                        new Archer(14),
                        new Archer(15),
                        new Archer(6),
                        new Archer(70),
                        new Archer(80),
                        new Swordsman(80),
                        new Swordsman(80),
                        new Swordsman(80),
                        new Swordsman(80),
                        new Swordsman(80),
                        new Mage(23),
                        new Mage(45),
                        new Mage(24),
                        new Mage(56),
                        new Mage(22),
                        new Mage(5)
                )
        );

        System.out.println(army.calculateTotalPower());
    }
}