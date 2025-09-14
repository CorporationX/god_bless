package school.faang.bjs2_85531;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan");
        Archer archer = new Archer("Legolas");

        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            warrior.attack(archer);
            if (!(archer.getHealth() > 0)) {
                break;
            }
            archer.attack(warrior);
            if (!(warrior.getHealth() > 0)) {
                break;
            }
        }
    }
}
