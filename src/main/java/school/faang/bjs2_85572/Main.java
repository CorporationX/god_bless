package school.faang.bjs2_85572;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Pavel");
        Archer archer = new Archer("Alesha");

        System.out.println(archer);
        for (int i = 0; i < 15; i++) {
            warrior.attack(archer);
            warrior.printCheckLive(archer);
            System.out.println(archer);
        }
    }
}