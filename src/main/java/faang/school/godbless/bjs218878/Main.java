package faang.school.godbless.bjs218878;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        System.out.println("Warrior's health before the attack: " + warrior.getHealth());
        System.out.println("Archer's health before the attack: " + archer.getHealth());

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("Warrior's health after the attack: " + warrior.getHealth());
        System.out.println("Archer's health after the attack: " + archer.getHealth());
    }
}
