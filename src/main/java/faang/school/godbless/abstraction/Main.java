package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("воин");
        Archer archer = new Archer("лучник");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(archer.health);
        System.out.println(warrior.health);
    }
}
