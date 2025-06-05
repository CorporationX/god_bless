package school.faang.abstraction;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var archer = new Archer("Carius");
        var warrior = new Warrior("Warcon");
        while (archer.isAlive()) {
            warrior.attack(archer);
        }
        if (!archer.isAlive()) {
            System.out.println(archer + " is dead!");
        }
        if (warrior.isAlive()) {
            System.out.println(warrior + " is win!");
        }
    }
}
