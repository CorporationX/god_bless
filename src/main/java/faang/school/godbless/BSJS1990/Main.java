package src.main.java.faang.school.godbless.BSJS1990;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Воин");
        Archer archer = new Archer("Лучник");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
