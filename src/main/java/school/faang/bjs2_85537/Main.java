package school.faang.bjs2_85537;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior", 23, 11, 3);
        Character archer = new Archer("Archer", 13, 53, 21);
        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
