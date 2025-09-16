package bjs2_85721;

public class Game {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Конан");
        Archer archer = new Archer("Леголас");

        System.out.println("Бой начинается!");
        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
        archer.attack(warrior);
    }
}