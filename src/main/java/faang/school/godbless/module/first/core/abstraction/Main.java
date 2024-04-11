package faang.school.godbless.module.first.core.abstraction;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer1");
        Warrior warrior = new Warrior("Warrior1");
        archer.attack(warrior);
        System.out.printf("Warrior health after attack: %s \n", warrior.getHealth());
        
        Archer anotherPoorArcher = new Archer("Archer2");
        Warrior anotherWarrior = new Warrior("Warrior2");
        anotherWarrior.attack(anotherPoorArcher);
        System.out.printf("Archer health after attack: %s \n", anotherPoorArcher.getHealth());
    }
}
