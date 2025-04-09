package gratsio_BJS2_68129;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Rain");
        Character archer = new Archer("Leo");
        System.out.printf("Warrior: %s %d %d %d %d\n", warrior.name, warrior.strength, warrior.dexterity, warrior.intelligence, warrior.health);
        System.out.printf("Archer: %s %d %d %d %d\n", archer.name, archer.strength, archer.dexterity, archer.intelligence, archer.health);
        warrior.attack(archer);
        System.out.println("Archer health: " + archer.health);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println("Warrior health: " + warrior.health);
    }
}
