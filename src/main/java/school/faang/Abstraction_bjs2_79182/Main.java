package school.faang.Abstraction_bjs2_79182;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer-1");
        Character warrior = new Warrior("Warrior-1");
        archer.attack(warrior);
        warrior.attack(archer);
    }
}
