package task_BJS2_61403;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        Squad archers = new Squad(CharacterType.ARCHER, List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad(CharacterType.SWORDSMAN, List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad(CharacterType.MAGICIAN, List.of(new Magician(50), new Magician(45)));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
