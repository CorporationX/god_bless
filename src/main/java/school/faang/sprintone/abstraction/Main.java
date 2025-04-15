package school.faang.sprintone.abstraction;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Лучник Лёха");
        Warrior warrior = new Warrior("Боец Андрюха");

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.printf("Здоровье лучника: %d%n", archer.health);
        System.out.printf("Здоровье бойца: %d%n", warrior.health);
    }
}