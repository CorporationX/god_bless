package school.faang.m3_1_parallelism.mightandmagic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad archers = new Squad(List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad(List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad(List.of(new Mage(50), new Mage(45)));

        Army army = new Army(List.of(archers, swordsmen, mages));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
