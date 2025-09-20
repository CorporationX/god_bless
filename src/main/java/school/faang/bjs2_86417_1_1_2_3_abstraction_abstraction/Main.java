package school.faang.bjs2_86417_1_1_2_3_abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Legolath");
        Warrior warrior = new Warrior("Kratos");

        System.out.println(warrior.health);
        for (int i = 0; i < 11; i++) {
            archer.attack(warrior);
            System.out.println(warrior.health);
        }
    }
}
