package school.faang.task_43842;


public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Thor");
        Archer archer = new Archer("Legolas");

        System.out.println(warrior.getName() + " has health: " + warrior.getHealth());
        System.out.println(archer.getName() + " has health: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getName() + " attacked by "
                + archer.getName() + " and now has health: " + warrior.getHealth());

        warrior.attack(archer);
        System.out.println(archer.getName() + " attacked by "
                + warrior.getName() + " and now has health: " + archer.getHealth());
    }
}
