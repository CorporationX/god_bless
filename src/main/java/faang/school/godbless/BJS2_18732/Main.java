package faang.school.godbless.BJS2_18732;

public class Main {
    public static void main(String[] args) {

        Character archer = new Archer("Alex");
        Character warrior = new Warrior("Orca");

        // До сражения
        System.out.println("Лучник: " + archer);
        System.out.println("Воин: " + warrior);

        archer.attack(warrior);
        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);

        // После сражения
        System.out.println("Лучник: " + archer);
        System.out.println("Воин: " + warrior);
    }
}
