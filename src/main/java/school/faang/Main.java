package school.faang;

public class Main {

    public static void main(String[] args) {
        Character warrior = new Warrior("Alex");
        Character archer = new Archer("Ivan");
        System.out.println(
                "warrior health: " + warrior.getHealth() +
                "; archer health: " + archer.getHealth()
        );
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(
                "warrior health: " + warrior.getHealth() +
                "; archer health: " + archer.getHealth()
        );
    }
}
