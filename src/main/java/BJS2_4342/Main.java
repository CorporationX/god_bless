package BJS2_4342;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Монклерк");
        Character archer = new Archer("Ежон");

        while (warrior.getHealthPoint() > 0 || archer.getHealthPoint() > 0) {
            warrior.attack(archer);
            archer.attack(warrior);
        }
        if (warrior.getHealthPoint() > archer.getHealthPoint()) {
            System.out.println("Победил " + warrior.getName());
        } else {
            System.out.println("Победил " + archer.getName());
        }
    }
}
