package faang.school.godbless.abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Воин");
        Archer archer = new Archer("Лучник");

        System.out.println("Здоровье воина: " + warrior.health);
        System.out.println("Здоровье лучника: " + archer.health);
        System.out.println();

        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println();

        System.out.println("Здоровье воина после атаки: " + warrior.health);
        System.out.println("Здоровье лучника после атаки: " + archer.health);
        System.out.println();
    }
}
