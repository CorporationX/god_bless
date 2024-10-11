package school.faang;

public class Main {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("Mark");
        Archer archer = new Archer("Andrei");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(archer.getName() + " to have " + archer.getHealth() + " health.");
        System.out.println(warrior.getName() + " to have " + warrior.getHealth() + " health.");
    }

}
