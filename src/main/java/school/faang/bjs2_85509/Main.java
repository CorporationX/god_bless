package school.faang.bjs2_85509;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("warriorOne");
        Archer archer = new Archer("archerOne");

        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            warrior.attack(archer);
            archer.validateHealth(archer.getHealth());

            archer.attack(warrior);
            warrior.validateHealth(warrior.getHealth());
        }
    }
}
