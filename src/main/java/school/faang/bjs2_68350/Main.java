package school.faang.bjs2_68350;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");
        Archer archer2 = new Archer("Archer2");

        warrior.attack(archer2);
        warrior.attack(archer);
        warrior.attack(archer2);
        warrior.attack(archer);
        archer.attack(archer2);
        archer.attack(warrior);
    }

}