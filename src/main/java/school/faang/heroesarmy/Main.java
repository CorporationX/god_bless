package school.faang.heroesarmy;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad(List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad(List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad(List.of(new Mage(50), new Mage(45)));

        List<Squad> squads = List.of(archers, swordsmen, mages);
        Army army = new Army();
        int totalPower = army.calculateTotalPower(squads);
        System.out.println(totalPower);
    }


}
