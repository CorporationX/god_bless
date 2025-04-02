package school.faang.distributed_army;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad<Archer> archercs = new Squad<>(new Archer(), 5);
        Squad<Mage> mages = new Squad<>(new Mage(), 2);
        Squad<Swordsman> swordsmen = new Squad<>(new Swordsman(), 10);
        Army army = new Army(List.of(archercs, mages, swordsmen));
        System.out.println(army.calculateTotalPower());
    }
}
