package school.faang.BJS2_31387;

public class TestCharacter {
    public static void main(String[] args) {
        Character warrior = new Warrior("Evander");
        Character archer = new Archer("Hawkeye");

        warrior.attack(archer);
        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);

        System.out.println("Warrior: " + warrior.getName() + "'s zdorovye is: " + warrior.getZdorovye());
        System.out.println("Archer: " + archer.getName() + "'s zdorovye is: " + archer.getZdorovye());
    }
}
