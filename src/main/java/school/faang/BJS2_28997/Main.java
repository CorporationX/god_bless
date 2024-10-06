package school.faang.BJS2_28997;


public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Чарна");
        Archer archer = new Archer("Валеска");

        warrior.attack(archer);
        System.out.printf("%s: %s%n", archer.name, archer.health);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.printf("%s: %s%n", warrior.name, warrior.health);
    }
}
