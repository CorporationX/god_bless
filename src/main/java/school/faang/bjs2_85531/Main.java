package school.faang.bjs2_85531;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan");
        Archer archer = new Archer("Legolas");

        while (true) {
            warrior.attack(archer);

            archer.attack(warrior);
            if (warrior.isKilling() || archer.isKilling()) {
                break;
            }
        }
    }
}
