package school.faang.bjs2_85531;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan");
        Archer archer = new Archer("Legolas");

        while (warrior.isAlive() && archer.isAlive()) {
            warrior.attack(archer);
            if (!archer.isAlive()) {
                break;
            }
            archer.attack(warrior);
            if (!warrior.isAlive()) {
                break;
            }
        }
    }
}
