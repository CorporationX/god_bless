package school.faang.task_43841;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        warrior.attack(archer);
        System.out.println(archer.getName() + " health: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getName() + " health: " + warrior.getHealth());
    }
}