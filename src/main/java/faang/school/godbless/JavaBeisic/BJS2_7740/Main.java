package faang.school.godbless.JavaBeisic.BJS2_7740;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        System.out.println("Initial Health of " + warrior.getName() + ": " + warrior.getHealth());
        System.out.println("Initial Health of " + archer.getName() + ": " + archer.getHealth());

        warrior.attack(archer);
        System.out.println("Health of " + archer.getName() + " after attack: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println("Health of " + warrior.getName() + " after attack: " + warrior.getHealth());
    }
}
