package school.faang.task_43876;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warr");
        Archer archer = new Archer("Arch");

        Warrior warrior2 = new Warrior("Warr2", 100, 0, 0);
        Archer archer2 = new Archer("Arch2", 100, 3, 3);

        System.out.println("Health " + archer.getName() + " before attack " + warrior.getName() + " - " + archer.getHealth());
        warrior.attack(archer);
        System.out.println("Health " + archer.getName() + " after attack - " + warrior.getName() + " - " + archer.getHealth());

        System.out.println("Health " + warrior2.getName() + " before attack - " + archer2.getName() + " - " + warrior2.getHealth());
        archer2.attack(warrior2);
        System.out.println("Health " + warrior2.getName() + " after attack - " + archer2.getName() + " - " + warrior2.getHealth());


    }
}
