package faang.school.godbless.BJS2_5314;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        System.out.println("Warrior health: " + warrior.health);
        System.out.println("Archer health: " + archer.health);
        System.out.println();

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println("Warrior health: " + warrior.health);
        System.out.println("Archer health: " + archer.health);
    }
}
