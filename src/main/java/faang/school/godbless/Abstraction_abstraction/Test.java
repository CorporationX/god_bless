package faang.school.godbless.Abstraction_abstraction;

public class Test {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Bob");
        Archer archer = new Archer("Tod");

        Archer archer1 = new Archer("Bill", 3, 7, 5);

        archer1.attack(warrior);
        archer1.attack(warrior);
        archer1.attack(warrior);

        System.out.println(warrior.health);

        warrior.attack(archer1);
        warrior.attack(archer1);

        System.out.println(archer1.health);
    }
}
