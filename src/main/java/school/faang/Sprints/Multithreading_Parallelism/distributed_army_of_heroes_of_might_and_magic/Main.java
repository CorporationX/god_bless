package school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic;

import school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic.Units.Archer;
import school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic.Units.Mage;
import school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic.Units.Swordsman;

public class Main {
    public static void main(String[] args){
        Army army = new Army();
        for (int i = 0; i < 2; i++) {
            army.addUnit(new Mage());
            army.addUnit(new Archer());
        }
        army.addUnit(new Swordsman());

        int totalPower = army.calculateTotalPower();
        System.out.println("Army strength " + totalPower);
    }

}