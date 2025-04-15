package school.faang.BJS2_68253;

public class Main {
    public static void main(String[] args) {

        Character warrior = new Warrior("Peter");
        Character archer = new Archer("Alex");

        System.out.println("The battle between " + warrior.getName() + " and " + archer.getName() + "\n");

        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            warrior.attack(archer);
            System.out.println(archer.getName() + "'s health: " + archer.getHealth());

            if (archer.getHealth() <= 0) {
                break;
            }

            archer.attack(warrior);
            System.out.println(warrior.getName() + "'s health: " + warrior.getHealth());
        }

        System.out.println("The battle is over!");
        if (warrior.getHealth() <= 0) {
            System.out.println(warrior.getName() + " has fallen in battle!");
        } else if (archer.getHealth() <= 0) {
            System.out.println(archer.getName() + " has fallen in battle!");
        }
    }
}


