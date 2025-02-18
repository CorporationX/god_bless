package school.faang.task_61101;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Squad archers = new Squad(List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad(List.of(new Swordsman(70), new Swordsman(75)));
        Squad magicians = new Squad(List.of(new Mage(50), new Mage(60)));
        Army army = new Army(List.of(archers, swordsmen, magicians));

        System.out.println("The overall strength of the army: " + army.calculateTotalPower());
    }
}
