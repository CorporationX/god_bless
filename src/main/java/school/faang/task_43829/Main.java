package school.faang.task_43829;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Oleg");
        Warrior warrior = new Warrior("Tim");

        while (warrior.health > 0 || archer.health > 0) {
            archer.attack(warrior);
            warrior.attack(archer);
            System.out.println("Heath of warrior after attack: " + warrior.health + ". Heath of archer after attack: " + archer.health);
        }

    }
}
