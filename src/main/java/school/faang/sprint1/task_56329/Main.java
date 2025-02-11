package school.faang.sprint1.task_56329;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Conan");
        Character archer = new Archer("Legolas");

        System.out.println(archer.getName() + " health before attack: " + archer.getHealth());
        warrior.attack(archer);
        System.out.println(archer.getName() + " health after attack: " + archer.getHealth());

        System.out.println(warrior.getName() + " health before attack: " + warrior.getHealth());
        archer.attack(warrior);
        System.out.println(warrior.getName() + " health after attack: " + warrior.getHealth());
    }
}
