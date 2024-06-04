package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Ork");
        Archer archer = new Archer("Ninja");

        while (warrior.isAlive() && archer.isAlive()) {
            if (archer.isAlive()) {
                archer.attack(warrior);
            }

            if (warrior.isAlive()) {
                warrior.attack(archer);
            }

            System.out.println("Warriors health: " + warrior.getHealth());
            System.out.println("Archers health " + archer.getHealth());
        }
    }
}
