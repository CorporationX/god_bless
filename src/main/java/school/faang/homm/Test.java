package school.faang.homm;

import java.util.List;

public class Test {
    public static void main(String[] args) {


        Squad archers = new Squad(List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad(List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad(List.of(new Mage(50), new Mage(45)));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
