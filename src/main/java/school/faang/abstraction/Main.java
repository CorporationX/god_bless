package school.faang.abstraction;


public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Чарна");
        Character archer = new Archer("Валеска");

        warrior.attack(archer);
        System.out.printf("%s: %s%n", archer.name, archer.health);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.printf("%s: %s%n", warrior.name, warrior.health);
    }
}
