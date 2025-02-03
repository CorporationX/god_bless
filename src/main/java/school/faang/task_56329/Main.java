package school.faang.task_56329;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Conan");
        Character archer = new Archer("Legolas");

        warrior.attack(archer);
        System.out.println(archer.getName() + " health: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getName() + " health: " + warrior.getHealth());
    }
}
