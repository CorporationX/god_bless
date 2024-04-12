package faang.school.godbless;

import faang.school.godbless.abstractionabstraction.Archer;
import faang.school.godbless.abstractionabstraction.Warrior;

public class Application {
    public static void main(String[] args) {
        Warrior myWarrior = new Warrior("Konan");
        Archer myArcher = new Archer("Legalas");
        System.out.println(myWarrior);
        System.out.println(myArcher);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        myWarrior.attack(myArcher);
        System.out.println(myArcher);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        myArcher.attack(myWarrior);
        System.out.println(myWarrior);
    }
}
