package school.faang.abstraction;

public class TestCharacter {
    public static void main(String[] args) {
        Character warrior = new Warrior("Evander");
        Character archer = new Archer("Hawkeye");

        warrior.attack(archer);
        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);

        System.out.println("Warrior: " + warrior.getName() + "'s health is: " + warrior.getHealth());
        System.out.println("Archer: " + archer.getName() + "'s health is: " + archer.getHealth());
    }
}
