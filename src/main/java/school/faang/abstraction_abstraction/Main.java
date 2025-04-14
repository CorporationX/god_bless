package school.faang.abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("archer");
        Character warrior = new Warrior("warrior");

        System.out.println("warrior strength = " + warrior.getStrength());
        System.out.println("archer agility = " + archer.getAgility());
        System.out.println("fight...");

        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("archer health = " + archer.getHealth());
        System.out.println("warrior health = " + warrior.getHealth());
    }
}
