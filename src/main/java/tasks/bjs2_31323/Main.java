package tasks.bjs2_31323;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Грек-Хак");
        Archer archer = new Archer("Джелу");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
